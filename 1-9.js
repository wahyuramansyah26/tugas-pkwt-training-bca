// 1. 
const nama = "M. Wahyu Ramansyah"
const umur = 22
const pendidikanTerakhir = "S1 - Sistem Komputer"
const bahasaPemrograman = "Java, Python, C++, Javascript"


console.log("Nama : " + nama)
console.log("Umur : " + umur)
console.log("Pendidikan terakhir : " + pendidikanTerakhir)
console.log("Pemrograman yang pernah dipelajari : " + bahasaPemrograman)


// 2. Jelaskan perbedaan var,let, dan const
// var : digunakan untuk global variabel, dapat diassign nilai kembali
// let : merupakan variabel block scope, dapat diassign nilai kembali
// const : merupakan variabel block scope, tidak dapat diassign nilai kembali
var tes1 = "saya"
let tes2 = 0
const tes3 = "11/11/2000"


// 3.
let angka = 9
if (angka % 2 == 0) {
    console.log("Genap")
}else {
    console.log("Ganjil")
}

// 4.
let harga = 50000
if (harga >= 25000) {
    console.log("Harga mahal")
}else if (harga > 10000) {
    console.log("Harga Sedang")
}else if (harga > 0 && harga < 10000) {
    console.log("Harga Murah")
}

// 5. 
for(let index=10; index <=15; index++){
    console.log(index)
}

let index=10
while(index <= 15){
    console.log(index)
    index++
}

index = 10
do{
    console.log(index)
    index++
}while(index <= 15)

// 6.
function ongkosKirim(jarak){
    let totalOngkir
    let ongkir1
    let selisihJarak
    if (jarak <= 2){
        totalOngkir = 5000
    }else{
        selisihJarak = jarak - 2
        ongkir1 = selisihJarak * 3000
        totalOngkir = 5000 + ongkir1
    }
    return totalOngkir
}

let ongkir = ongkosKirim(8)
console.log(ongkir)

// 7.
const cetakKata = (angka) => {
    if (angka % 3 == 0 && angka % 5 == 0) {
        console.log("fazztrack")
    }else if (angka % 3 == 0) {
        console.log("fazz")
    }else if (angka % 5 == 0) {
        console.log("track")
    }
}

cetakKata(40)

// 8. 
const segitigaTerbalik = function(angka){
    for(let i=0; i < angka; i++) {
        for(let j = angka; j > i; j--) {
            process.stdout.write("* ")
        }
        console.log("")
    }
}

segitigaTerbalik(6)

// 9. 
const persegiBolong = (angka) => {
    for (let i=0; i < angka; i++) {
        for (let j=0; j < angka; j++) {
            if (i == 0 || j == 0 || i == angka-1 || j == angka-1){
                process.stdout.write("* ")
            }else{
                process.stdout.write("  ")
            }  
        }
        console.log("")
    }
}

persegiBolong(10)

// 10.