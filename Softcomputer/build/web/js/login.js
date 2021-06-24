function comprobarlogin() 
{
    // optengo los datos del login.html txtusuario y txtpassword
    var textusuario = $('#txtusuario').val();
    var textpassword = $('#txtpassword').val();

    // transformo los datos en objetos json para que el servicio web los resiva en un objeto
    var dato = {
        username : textusuario,
        passuser : textpassword
    };
    debugger;

    // consulta el servicio web mediante la peticion POST
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
                $(location).attr("href", "catalogo.html");
                return;
            }
            console.log(response);
        },
        error:function(error){
            alert("error" + error);
        }
    });

}