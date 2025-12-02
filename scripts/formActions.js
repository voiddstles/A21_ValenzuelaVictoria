const NACIONALIDADES_ACEPTADAS = [
    {key: 'AU', name: "Australia"},
    {key: 'BR', name: "Brasil"},
    {key: 'CA', name: "Canadá"},
    {key: 'CH', name: "Suiza"},
    {key: 'DE', name: "Alemania"},
    {key: 'DK', name: "Dinamarca"},
    {key: 'ES', name: "España"},
    {key: 'FI', name: "Finlandia"},
    {key: 'FR', name: "Francia"},
    {key: 'GB', name: "Reino Unido"},
    {key: 'IE', name: "Irlanda"},
    {key: 'IN', name: "India"},
    {key: 'IR', name: "Irán"},
    {key: 'MX', name: "México"},
    {key: 'NL', name: "Países Bajos"},
    {key: 'NO', name: "Noruega"},
    {key: 'NZ', name: "Nueva Zelanda"},
    {key: 'RS', name: "Serbia"},
    {key: 'TR', name: "Turquía"},
    {key: 'UA', name: "Ucrania"},
    {key: 'US', name: "Brasil"},
]

window.onload=function(){
    const form = document.getElementsByTagName("form"); 
    if (form.length === 0) return; 
    
    const inputs = form[0].getElementsByTagName("input"); 
    const selects = form[0].getElementsByTagName("select"); 

    function resaltarEtiqueta(elemento){
        const label = document.querySelector(`label[for="${elemento.id}"]`);
        if(label) label.classList.add("focused-label");
    }

    function desresaltarEtiqueta(elemento){
        const label = document.querySelector(`label[for="${elemento.id}"]`);
        if(label) label.classList.remove("focused-label");
    }

    function resaltarDesresaltar(evento){
        evento.target.classList.toggle("selected");
        if (evento.type === 'focus') {
            resaltarEtiqueta(evento.target);
        } else if (evento.type === 'blur') {
            desresaltarEtiqueta(evento.target);
        }
    }

    function validarEnTiempoReal(evento) {
        const input = evento.target;
        const valor = input.value;
        const label = document.querySelector(`label[for="${input.id}"]`);
        const errorClase = 'error-input'; 
        const errorLabelClase = 'error-label'; 

        if (valor.trim() === "") {
            input.classList.add(errorClase);
            if(label) label.classList.add(errorLabelClase);
        } else {
            input.classList.remove(errorClase);
            if(label) label.classList.remove(errorLabelClase);
        }

        if (input.id === 'first-name' || input.id === 'last-name') {
            const regexSoloLetras = /^[a-zA-ZñÑáéíóúÁÉÍÓÚ\s]*$/; 
            
            if (!regexSoloLetras.test(valor)) {
                input.classList.add(errorClase);
                if(label) label.classList.add(errorLabelClase);
            } else if (valor.trim() !== "") {
                input.classList.remove(errorClase);
                if(label) label.classList.remove(errorLabelClase);
            }
        }
    }

    for(let input of inputs){
        input.onfocus = resaltarDesresaltar;
        input.addEventListener('blur', resaltarDesresaltar); 
        input.addEventListener('input', validarEnTiempoReal); 
    }

    for(let select of selects){ 
        select.onfocus = resaltarDesresaltar; 
        select.addEventListener('blur', resaltarDesresaltar); 
    }

    llamarNacionalidad();
}

function llamarNacionalidad(){ 
    const nacionalidad = document.getElementById("nationality");
    for(const nacion of NACIONALIDADES_ACEPTADAS){ 
        const option = document.createElement("option");
        option.innerHTML = nacion.name; 
        option.value = nacion.key; 
        nacionalidad.appendChild(option);
    }
}

function resaltar(events){
    events.target.classList.add("selected");
}

function noResaltar(events){
    const clase = events.target.classList.contains("selected"); 
    if(clase){
        events.target.classList.remove("selected"); 
    }
}

function resaltarDesresaltar(evento){
    evento.target.classList.toggle("selected");
}