

// SHOW MENU

const showMenu = (toggleId, navbarId,bodyId) =>{
    const toggle = document.getElementById(toggleId),
        navbar = document.getElementById(navbarId),
        bodypadding = document.getElementById(bodyId)

    if(toggle && navbar){
        toggle.addEventListener('click', ()=>{
            // APARECER MENU
            navbar.classList.toggle('show')
            // ROTATE TOGGLE
            toggle.classList.toggle('rotate')
            // PADDING BODY
            bodypadding.classList.toggle('expander')
        })
    }
}
showMenu('nav-toggle','navbar','body')


const linkColor = document.querySelectorAll('.nav__link');
const sections = {
    plan_turistico: document.getElementById('plan_turistico_content'),
    puntos_visita: document.getElementById('puntos_visita_content'),
    vendedores: document.getElementById('vendedores_content'),
    clientes: document.getElementById('clientes_content'),
    estadisticas: document.getElementById('estadisticas_content'),
    notas: document.getElementById('notas_content')
};

function colorLink() {
    // Remove the 'active' class from all navigation links
    linkColor.forEach(l => l.classList.remove('active'));

    // Add the 'active' class to the clicked navigation link
    this.classList.add('active');

    // Hide all sections
    for (const section in sections) {
        sections[section].classList.add('d-none');
    }

    // Show the clicked section
    if (sections[this.id]) {
        sections[this.id].classList.remove('d-none');
    }
}

// Attach the event listener to each navigation link
linkColor.forEach(l => l.addEventListener('click', colorLink));