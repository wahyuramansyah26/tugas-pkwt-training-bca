fetch("https://jsonplaceholder.typicode.com/users").then(
  res => {
    res.json().then(
      data => {
        console.log(data);
        if (data.length > 0) {

          var temp = "";
          data.forEach((itemData) => {
            temp += "<tr>";
            temp += "<td>" + itemData.id + "</td>";
            temp += "<td>" + itemData.name + "</td>";
            temp += "<td>" + itemData.email + "</td>";
            temp += "<td>" + itemData.address.street + "</td>";
            temp += "<td>" + itemData.company.name + "</td>";
            temp += "<td>" + itemData.phone + "</td></tr>";
          });
          document.getElementById('data').innerHTML = temp;
        }
      }
    )
  }
)