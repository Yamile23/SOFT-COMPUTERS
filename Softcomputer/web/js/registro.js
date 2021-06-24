function registro(){
    var textuser =$('txtuser').val();
    var textpass =$('txtpass').val();
    var textemail =$('txtemail').val();
    var textcel=$('txtcel').val();
    
    var dato={
        
        username :textuser,
        pass : textpass,
        email: textemail,
        celphone: textcel
    };
    debugger;
    
    $.ajax({
         type: "POST",
        url: "api/usuarios/login",
        dataType: "json",
        "headers": {
            "Content-Type": "application/json"
          },
        data: JSON.stringify(dato),
        success: function (response) {
            // respuesta del servidor
            debugger;

            if(response.isOK){
                localStorage.setItem("userInSession" , response.username);
                //document.location.href = "template/paginaprincipal.html";
                $(location).attr("href", "login.html");
                return;
            }
            console.log(response);
        },
        error:function(error){
            alert("error" + error);
        }
    });
    
}


