/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var pepe;
function valida(f) {
  let pepe;
  let ok = true;
  let msg = "Debes escribir contenido en los campos:\n";
  if(f.elements[0].value === "")
  {
    msg += "- Marca 1\n";
    ok = false;
  }

  if(f.elements["nombre"].value === "")
  {
    msg += "- Marca 2\n";
    ok = false;
  }

  if(f.apellido.value === "")
  {
    msg += "- Marca 3\n";
    ok = false;
  }
  
  document.getElementById("demo").innerHTML = "Formulario correcto";
  window.alert("Su formulario ha sido enviado");

  if(ok === false)
    alert(msg);
  return ok;
}
