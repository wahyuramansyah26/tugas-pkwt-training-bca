import { createSlice } from '@reduxjs/toolkit'

const userSlice = createSlice({
    name: 'users',
    initialState: {
        accessToken: '',
        isAuth: false,
        data: {}
    },
    reducers: {
        login(state, actions) {
            return {
                ...state,
                isAuth: true,
                accessToken: actions.payload.accessToken,
                data : actions.payload.user
                
            }
        },
        logout(state, actions) {
            return {
                ...state,
                isAuth: false,
                accessToken: '',
                data: {}
            }
        }
    }
})

export const { login, logout } = userSlice.actions
export default userSlice.reducer