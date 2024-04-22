<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html lang="en">
<head>
    
<title>Connexion Amin</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="./style/style.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css">
<script src="https://cdn.jsdelivr.net/npm/vue@2.6.12/dist/vue.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
<style>
body,h1,h2,h3,h4,h5,h6 {font-family: "Lato", sans-serif}
.w3-bar,h1,button {font-family: "Montserrat", sans-serif}
.fa-anchor,.fa-coffee {font-size:200px}

</style>
</head>
<body>


<jsp:include page = "enTete.jsp"/>

<!-- Header -->
<header class="mainimage" style="padding:128px 16px">
  <h1 class="w3-margin w3-jumbo">Connexion pour les administrateurs</h1>
</header>

<!-- First Grid -->

    <div class="container mt-5">
      <div class="row d-flex justify-content-center">
        
          <div class="col-md-6">
              <div class="card px-5 py-5" id="form1">
                  
                      
                  <div class="form-data" v-if="!submitted">
                      <form action=ConnexionAdminController method="get">
                      <div class="forms-inputs mb-4"> <span>Email</span> <input name="email" autocomplete="off" type="text" v-model="email" v-bind:class="{'form-control':true, 'is-invalid' : !validEmail(email) && emailBlured}" v-on:blur="emailBlured = true">
                          <div class="invalid-feedback">Un email valide est requis!</div>
                      </div>

                      <div class="forms-inputs mb-4"> <span>Password</span> <input name="password" autocomplete="off" type="password" v-model="password" v-bind:class="{'form-control':true, 'is-invalid' : !validPassword(password) && passwordBlured}" v-on:blur="passwordBlured = true">
                          <div class="invalid-feedback">Le mot de passe doit faire 8 caractères!</div>

                      </div>
                      <div class="mb-3"> <button type="submit" class="btn btn-dark w-100">Login</button> </div>
                      </form>
                  </div>
                  
                  <div class="success-data" v-else>

                      <div class="text-center d-flex flex-column"> <i class='bx bxs-badge-check'></i> <span class="text-center fs-1">Vous vous êtes connecté avec<br> Succès</span> </div>

                  </div>
              </div>
          </div>
      </div>
  </div>

   
  

<!-- Second Grid -->

<div class="w3-container w3-black w3-center w3-opacity w3-padding-64">
    <h1 class="w3-margin w3-xlarge">Bienvenue sur la page admin</h1>
</div>


<jsp:include page = "footer.jsp"/>


<script>
// Used to toggle the menu on small screens when clicking on the menu button
function myFunction() {
  var x = document.getElementById("navDemo");
  if (x.className.indexOf("w3-show") == -1) {
    x.className += " w3-show";
  } else { 
    x.className = x.className.replace(" w3-show", "");
  }
}
var app = new Vue({
  el: '#form1',
  data: function () {
    return {
    email : "",
    emailBlured : false,
    valid : false,
    submitted : false,
    password:"",
    passwordBlured:false
    }
  },

  methods:{

    validate : function(){
this.emailBlured = true;
this.passwordBlured = true;
if( this.validEmail(this.email) && this.validPassword(this.password)){
this.valid = true;
}
},

validEmail : function(email) {
   
var re = /(.+)@(.+){2,}\.(.+){2,}/;
if(re.test(email.toLowerCase())){
  return true;
}

},

validPassword : function(password) {
   if (password.length > 7) {
    return true;
   }
},

submit : function(){
this.validate();
if(this.valid){
this.submitted = true;
}
}
  }
});

</script>

</body>
</html>