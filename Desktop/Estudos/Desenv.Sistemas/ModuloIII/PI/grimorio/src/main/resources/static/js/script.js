$(document).ready(function () {
    // Paginas Inicialmente Escondidas
    $("#page-content").hide();
    $("#page-fav").hide();

    //Expandir menu lateral
    $("#expandBtn").click(function () {
        $(".sidenav").toggleClass("expanded");
    });

    // Evento de clique para o botão "Todas as Magias"
    $('#todasMagiasBtn').click(function () {
        toggleButton($(this), $('#favoritasBtn'));
        $("#page-content").show();
        $("#page-fav").hide();
    });

    // Evento de clique para o botão "Favoritas"
    $('#favoritasBtn').click(function () {
        toggleButton($(this), $('#todasMagiasBtn'));
        $("#page-fav").show();
        $("#page-content").hide();
    });

    // Evento de clique para detalhes
    $('#infoContent').click(function () {
        $('#part2').toggle();
    });

    $('#infoContent1').click(function () {
        $('#part3').toggle();
    });

    $('#cancelar').click(function () {
        window.location.replace; 
    });

});

// Estilo botão todas magias e favoritas quando clicado
function toggleButton(selectedBtn, unselectedBtn) {
    selectedBtn.addClass('btn-danger').removeClass('btn-secondary');
    unselectedBtn.removeClass('btn-danger').addClass('btn-secondary');
}

//Bolinhas
var isBolinhaFar = [true, true, true, true, true]; // Variável de controle de estado para cada bolinha

function toggleBolinha(numero) {

    var bolinha = $('#bolinha-' + numero);

    if (bolinha.length > 0) {
        if (isBolinhaFar[numero]) {
            bolinha.removeClass('far').addClass('fas');
        } else {
            bolinha.removeClass('fas').addClass('far');
        }

        isBolinhaFar[numero] = !isBolinhaFar[numero];

        console.log('Classes após a troca:', bolinha.attr('class'));
    } else {
        console.log('Elemento #bolinha-' + numero + ' não encontrado');
    }
}
//Conteudo minimizado
function toggleContent() {
    var contentContainer = document.querySelector('.content-container');
    var icon = document.querySelector('.toggle-icon');

    if (contentContainer.classList.contains('active')) {
        contentContainer.classList.remove('active');
        icon.innerHTML = '<i class="fas fa-chevron-down"></i>';
    } else {
        contentContainer.classList.add('active');
        icon.innerHTML = '<i class="fas fa-chevron-up"></i>';
    }
}

function openFileOption(id) {
    document.getElementById(id).style.display = "block";
}

var isFar = true; // Variável de controle de estado

function toggleFavorito() {

    var heartIcon = $('#heartIcon');


    if (heartIcon.length > 0) {

        if (isFar) {
            heartIcon.removeClass('far').addClass('fas');
        } else {
            heartIcon.removeClass('fas').addClass('far');
        }

        isFar = !isFar;

        console.log('Classes após a troca:', heartIcon.attr('class'));
    } else {
        console.log('Elemento #heartIcon não encontrado');
    }
}