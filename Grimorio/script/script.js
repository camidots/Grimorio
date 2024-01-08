$(document).ready(function () {
    // Paginas Inicialmente Escondidas
    $("#page-content").hide();
    $("#page-fav").hide();

    //Expandir menu lateral
    $("#expandBtn").click(function () {
        $(".sidenav").toggleClass("expanded");
    });


    //Favoritar
    $('#favorito').on('click', function () {
        $(this).find('i').toggleClass('far fas');
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

//Tooltip
$(document).ready(function () {
    $('[data-toggle="tooltip"]').tooltip();
});


//Bolinhas
function toggleBolinha(numero) {
    var bolinha = $("#bolinha-" + numero + " i");
    if (bolinha.hasClass("far")) {
        bolinha.removeClass("far").addClass("fas");
    } else {
        bolinha.removeClass("fas").addClass("far");
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









