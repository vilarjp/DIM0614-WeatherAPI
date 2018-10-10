document.addEventListener('DOMContentLoaded', function(){ 
  axios.get('http://localhost:8080/cities')
    .then(response => {
      if(response.status == 200) {
        console.log('tudo ok')
      }
    })
    .catch(error => {
      alert('A API CAIU!')
    })
})

var getCity = function () {
  var myList = document.getElementById('cidade');
  myList.innerHTML = '';
  var content = document.getElementById('getCityId').value
  axios.get('http://localhost:8080/cities/' + content)
  .then(function (response) {
    if(content == '') {
      var li = document.createElement('li');
      li.innerHTML = 'ID cannot be empty'
      document.getElementById('cidade').appendChild(li);
      return
    }
    response.data = response.data
    var li = document.createElement('li');
    var id = response.data.id
    var nome = response.data.name
    var umidade = response.data.weather.humidity
    var pressao = response.data.weather.humidity
    var temperatura = response.data.weather.temperature
    li.innerHTML = "ID: " + id + " / Nome: " + nome + " / Temperatura: " + temperatura + " / Umidade: " + umidade + " / Pressão: " + pressao
    document.getElementById('cidade').appendChild(li); 
  })
  .catch(function (error) {
    var li = document.createElement('li');
    li.innerHTML = "Status: " + error.response.data.status + " / Error: " + error.response.data.msg
    document.getElementById('cidade').appendChild(li);
  })
}

var getAllCities = function () {
  var myList = document.getElementById('cidades');
  myList.innerHTML = '';
  axios.get('http://localhost:8080/cities')
    .then(function (response) {
      for(var i = 0; i < response.data.length; i++) {
          var li = document.createElement('li');
          var id = response.data[i].id
          var nome = response.data[i].name      
          li.innerHTML = "ID: " + id + " / Nome: " + nome
          document.getElementById('cidades').appendChild(li);
      }
    })
    .catch(function (error) {
      var li = document.createElement('li');
      var msg = error.response.data.msg ? error.response.data.msg : error.response.data.error
      li.innerHTML = msg
      document.getElementById('cidades').appendChild(li);
    })
}

var postNewCity = function () {
  var myList = document.getElementById('cidade-post');
  myList.innerHTML = '';
  var content = document.getElementById('getCityName').value
  var city = {
    id: null,
    name: content,
  }
  axios.post('http://localhost:8080/cities', city)
    .then(function (response) {
      var myList = document.getElementById('cidade-post');
      myList.innerHTML = '';
      var li = document.createElement('li');
      if(response.status == 201) {
        li.innerHTML = "Sucesso"
      } else {
        li.innerHTML = "Falha"
      }
      document.getElementById('cidade-post').appendChild(li);
    })
    .catch(function (error) {
      var myList = document.getElementById('cidade-put');
      myList.innerHTML = '';
      for(var i = 0; i < error.response.data.errors.length; i++) {
        var li = document.createElement('li');
        li.innerHTML = error.response.data.errors[i].message
        document.getElementById('cidade-post').appendChild(li);
      }
    })
}

var updateCity = function () {
  var myList = document.getElementById('cidade-put');
  myList.innerHTML = '';
  var name = document.getElementById('getCityNamePut').value
  var id = document.getElementById('getCityIdPut').value
  var city = {
    id: id,
    name: name,
  }
  axios.put('http://localhost:8080/cities/' + id, city)
    .then(function (response) {
      var myList = document.getElementById('cidade-put');
      myList.innerHTML = '';
      var li = document.createElement('li');
      if(response.status == 204) {
        li.innerHTML = "Sucesso"
      } else {
        li.innerHTML = "Falha"
      }
      document.getElementById('cidade-put').appendChild(li);
    })
    .catch(function (error) {
      var myList = document.getElementById('cidade-put');
      myList.innerHTML = '';
      var network_error = error.message
      if(network_error == 'Network Error') {
        var li = document.createElement('li');
        li.innerHTML = 'ID cannot be empty'
        document.getElementById('cidade-put').appendChild(li);
        return
      } else {
          if(error.response.data.errors) {
            for(var i = 0; i < error.response.data.errors.length; i++) {
              var li = document.createElement('li');
              li.innerHTML = error.response.data.errors[i].message
              document.getElementById('cidade-put').appendChild(li);
            }
          } else {
            var li = document.createElement('li');
            var msg = error.response.data.msg ? error.response.data.msg : error.response.data.error
            li.innerHTML = msg
            document.getElementById('cidade-put').appendChild(li);
          }
      }
    })
}

var deleteCity = function () {
  var myList = document.getElementById('cidade-delete');
  myList.innerHTML = '';
  var id = document.getElementById('deleteCityId').value
  axios.delete('http://localhost:8080/cities/' + id)
    .then(function (response) {
      var myList = document.getElementById('cidade-delete');
      myList.innerHTML = '';
      var li = document.createElement('li');
      if(response.status == 204) {
        li.innerHTML = "Sucesso"
      } else {
        li.innerHTML = "Falha"
      }
      document.getElementById('cidade-delete').appendChild(li);
    })
    .catch(function (error) {
      var myList = document.getElementById('cidade-delete');
      myList.innerHTML = '';
      var network_error = error.message
      if(network_error == 'Network Error') {
        var li = document.createElement('li');
        li.innerHTML = 'ID cannot be empty'
        document.getElementById('cidade-delete').appendChild(li);
        return
      } else {
          if(error.response.data.errors) {
            for(var i = 0; i < error.response.data.errors.length; i++) {
              var li = document.createElement('li');
              li.innerHTML = error.response.data.errors[i].message
              document.getElementById('cidade-delete').appendChild(li);
            }
          } else {
            var li = document.createElement('li');
            var msg = error.response.data.msg ? error.response.data.msg : error.response.data.error
            li.innerHTML = msg
            document.getElementById('cidade-delete').appendChild(li);
          }
      }
    })
}