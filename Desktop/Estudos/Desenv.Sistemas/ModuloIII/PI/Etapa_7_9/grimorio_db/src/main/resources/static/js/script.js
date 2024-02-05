var idPerfilSelected = null;

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
        if (idPerfilSelected !== null) {
        toggleButton($(this), $('#favoritasBtn'));
        isFavoritasSelected = false;
        $("#page-content").show();
        $("#page-fav").hide();
        } else {
            exibirModal("Por favor, selecione um perfil antes de visualizar as magias.");
        }
    });
    
    // Evento de clique para o botão "Favoritas"
    $('#favoritasBtn').click(function () {   
        if (idPerfilSelected !== null) {
            toggleButton($(this), $('#todasMagiasBtn'));
            $("#page-fav").show();
            $("#page-content").hide();
            isFavoritasSelected = true;
            carregarListaMagiaFavoritada(idPerfilSelected);
        } else {
            exibirModal("Por favor, selecione um perfil antes de visualizar as magias favoritas.");
        }
    });

    $('#cancelar').click(function () {
        window.location.replace();
    });
    
    carregarListaPerfis();
    carregarListaMagias();
     
    $(document).ready(function () {
        $('#imagem').change(function () {
            var nomeImagem = $(this).val().split('\\').pop();


            $('#imagemLabel').val(nomeImagem);
            $('#imagemLabel').text(nomeImagem);
            var caminhoImagem = '/images/' + nomeImagem;
            $('#caminhoImagem').val(caminhoImagem);
            console.log('Caminho da Imagem Atualizado:', $('#imagemLabel').val());
        });
    });
    
    $('#cadastroPerfil').submit(function (event) {
        event.preventDefault();

        var nomePerfil = $('#nomePersonagem').val();
        var classe = $('#classe').val();
        var raca = $('#raca').val();
        var usuario = 1;
        var conta = 1;
        var nivelPersonagem = $('#nivel').val();
        var caminhoImagem = $('#caminhoImagem').val();
        
        if (!caminhoImagem) {
        caminhoImagem = '/images/perfil.jpg';
        }
                     
        var perfilAtualizado = {
            nomePerfil : nomePerfil,
            classe : {
               idClasse: classe
            },
            raca :  {
               idRaca: raca
            },
            usuario : {
               idUsuario: usuario
            },
            conta : {
               idConta: conta
            },
           nivelPersonagem : nivelPersonagem,
           caminhoImagem : caminhoImagem 
        };
        
        $.ajax({
            type: 'POST',
            url: '/api/pefil/criar',
            contentType: 'application/json',
            data: JSON.stringify(perfilAtualizado),
            success: function (data) {
                console.log('Analise atualizado com sucesso:', data);
                exibirModal('Perfil criado com sucesso!');
                window.location.href = "/index";
            },
            error: function (error) {
                exibirModal('Erro ao criar perfil', error);
            }
        });
    });
    
    $('#editarPerfilForm').submit(function (event) {
        event.preventDefault();
        
        var idPerfil = obterPerfilIdDaUrl();
        var nomePerfil = $('#nomePersonagem').val();
        var classe = $('#classe').val();
        var raca = $('#raca').val();
        var usuario = 1;
        var conta = 1;
        var nivelPersonagem = $('#nivel').val();
        var caminhoImagem = $('#caminhoImagem').val();
        $('#imagemLabel').text(caminhoImagem.toString());
        console.log(caminhoImagem.toString());
        if (!caminhoImagem) {
            $.ajax({
                type: "GET",
                url: "/api/pefil/detalhes/" +idPerfil,
                success: function (data) {
                 caminhoImagem = data.caminhoImagem;
                },
                error: function (error) {
                    console.error("Erro ao carregar lista de perfis: ", error);
                }
            });
        } 
        
        var perfilAtualizado = {
            idPerfil : idPerfil,
            nomePerfil : nomePerfil,
            classe : {
               idClasse: classe
            },
            raca :  {
               idRaca: raca
            },
            usuario : {
               idUsuario: usuario
            },
            conta : {
               idConta: conta
            },
           nivelPersonagem : nivelPersonagem,
           caminhoImagem : caminhoImagem 
        };
        
        $.ajax({
            type: 'PUT',
            url: '/api/pefil/atualizar/' + idPerfil,
            contentType: 'application/json',
            data: JSON.stringify(perfilAtualizado),
            success: function (data) {
                exibirModal('Perfil editado com sucesso!');
                window.location.href = "/index";
            },
            error: function (error) {
                exibirModal('Erro ao atualizar perfil', error);
            }
        });
    });
    
    $(document).on('click', '.toggle-content .toggle-icon', function () {
        var nivelClasses = $(this).closest(".toggle-content").attr('class');

        var nivelMatch = nivelClasses.match(/nivel-(\d+)/);

         if (nivelMatch && nivelMatch[1]) {
             var nivel = nivelMatch[1].toString();
             toggleContent(nivel);              
            }  
    });       
});

function obterPerfilIdDaUrl() {
       var urlPartes = window.location.pathname.split('/');
       var ultimoSegmento = urlPartes[urlPartes.length - 1];
       var perfilId = parseInt(ultimoSegmento);
       return isNaN(perfilId) ? null : perfilId;
}

// Estilo botão todas magias e favoritas quando clicado
function toggleButton(selectedBtn, unselectedBtn) {
    selectedBtn.addClass('btn-danger').removeClass('btn-secondary');
    unselectedBtn.removeClass('btn-danger').addClass('btn-secondary');
}

//Conteudo minimizado
function toggleContent(nivel) {
    var grupoMagia = $(".toggle-content.nivel-" + nivel);
    var contentContainer = grupoMagia.find(".content-container");
    var icon = grupoMagia.find(".toggle-icon");

    contentContainer.toggleClass('active');
    icon.html(contentContainer.hasClass('active') ? '<i class="fas fa-chevron-up"></i>' : '<i class="fas fa-chevron-down"></i>');
}


function openFileOption(id) {
    document.getElementById(id).style.display = "block";
}




// REST API PERFIL

function carregarListaPerfis() {
    $.ajax({
        type: "GET",
        url: "/api/pefil/listar",
        success: function (data) {
            exibirListaPerfisNoIndex(data);
        },
        error: function (error) {
            console.error("Erro ao carregar lista de perfis: ", error);
        }
    });
}

function exibirListaPerfisNoIndex(perfis) {
    var perfilContainer = $("#perfilContainer");
        perfilContainer.empty();
        
        perfis.forEach(function (perfil) {
            var profileLink = $("<a>")
            .attr("href", "#") 
            .addClass("profile-link")
            .attr("data-id", perfil.idPerfil)
            .attr("title", perfil.nome) 
            .attr("data-boundary", "window")
            .append(
                $("<img>")
                    .attr("src", perfil.caminhoImagem)
                    .attr("alt", "Imagem de Perfil")
                    .addClass("profile-image")
                    .attr("id", "profile"),
                $("<span>")
                    .addClass("menu-label")
                    .append(
                        $("<div>")
                            .addClass("profile-info")
                            .on('click', function(event) {
                            window.location.replace('/edicaoPerfil/' + perfil.idPerfil);
                            })
                            .append(                                 
                                $("<div>")
                                    .addClass("name")
                                    .text(perfil.nomePerfil),
                                $("<div>")
                                    .append(
                                        $("<span>")
                                            .addClass("level-bar")
                                            .text("Level " + perfil.nivelPersonagem),
                                        $("<span>")
                                            .text(perfil.raca.nomeRaca)
                                            .css("margin-left", "5px"),
                                        $("<div>")
                                            .text(perfil.classe.nomeClasse)
                                    )
                            ),
                                $("<div>")
                                .addClass("delete-icon-container")  // Adiciona uma classe para o contêiner da lixeira
                                .append(
                                    $("<i>")
                                        .addClass("delete-icon fas fa-trash-alt")
                                        .attr("title", "Excluir")
                                        .data("data-id", perfil.idPerfil)
                                        .attr("id", "btnOpenDeleteModal")
                                        .css("cursor", "pointer")
                                        .css("margin-left", "15px")
                                        .on("click", function () {
                                            console.log("aqu");
                                        })
                                )
                                .on("click", function (event) {
                                    event.stopPropagation(); 
                            
                                    if (idPerfilSelected !== null) {
                                        $('#deleteModal').modal('show');
                                    } else {
                                        exibirModal("Por favor, selecione um perfil antes de excluir.");
                                    }
                                    
                                })
                    )
            );
    
            
            profileLink.on("click", function() { // Marcar perfil selecionado e guardar o id
                    var isSelected = $(this).hasClass("selected");
                    var personagemSelecionadoId = $(this).attr("data-id");
                    $(".profile-image").removeClass("selected");

                    if (!isSelected) {
                        $(this).find(".profile-image").addClass("selected");
                        console.log("ID do personagem selecionado: " + personagemSelecionadoId);
                        idPerfilSelected = personagemSelecionadoId; 
                        carregarListaMagiaFavoritada(idPerfilSelected);
                        carregarListaMagias(idPerfilSelected);
                    } else {
                        console.log("Perfil desselecionado");
                        personagemSelecionadoId = null;
                    }
                });
        $("#perfilContainer").append(profileLink);
        profileLink.tooltip();
    });
}
 
function deletePerfil() {
    console.log("aqui");
    if (idPerfilSelected !== null) {
          console.log(idPerfilSelected );  
          
         $.ajax({
            type: 'GET',
            url: '/api/magiaFavoritada/listar',
            success: function (data) {
                var filteredMagias = data.filter(function (magiaFavoritada) {
                    return String(magiaFavoritada.perfil.idPerfil) === String(idPerfilSelected);
                });
                console.log(filteredMagias);
                if (filteredMagias.length > 0) {
                    deleteMagiaFavoritadaPerfil(filteredMagias);
                    excluirPerfil(idPerfilSelected);
                } else {
                    excluirPerfil(idPerfilSelected);
                }
            },
            error: function (error) {
                console.error("Erro ao obter magias favoritadas:", error);
            }
        });
    
    } else {
            exibirModal("Por favor, selecione um perfil antes de excluir.");
    }
}

function deleteMagiaFavoritadaPerfil(filteredMagias) {
    
    filteredMagias.forEach(function (magiaFavoritada) {

        $.ajax({
            type: 'DELETE',
            url: '/api/magiaFavoritada/excluir/' + magiaFavoritada.idMagiaFavoritada,
            success: function () {
                console.log("Magia favoritada excluída com sucesso.", magiaFavoritada);
            },
            error: function (error) {
                console.error("Erro ao excluir magia favoritada:", error);
            }
        });
    });
}

function excluirPerfil(id) {
    $.ajax({
        type: 'DELETE',
        url: '/api/pefil/excluir/' + id,
        success: function () {
            exibirModal('Perfil excluído com sucesso');
            window.location.href = "/index";
        },
        error: function () {
            exibirModal('Erro ao excluir o perfil');
        }
    });
}

window.onload = function () {
    var perfilId = obterPerfilIdDaUrl();

    if (perfilId !== null) {
        getProfileDetails(perfilId);
    } 
};
 
function getProfileDetails(perfilId) {
    console.log(perfilId);
       $.ajax({
           url: '/api/pefil/detalhes/' + perfilId,
           type: 'GET',
           success: function(data) {
                console.log(data);
                $('#perfilId').val(data.idPerfil);
                $('#nomePersonagem').val(data.nomePerfil);
                $('#raca').val(data.raca.idRaca);
                $('#classe').val(data.classe.idClasse);
                $('#nivel').val(data.nivelPersonagem);
                $('#caminhoImagem').val(data.caminhoImagem);
           },
           error: function(error) {
               console.log(error);
           }
       });
   }
   
   
   
   
   

// REST API TODAS AS MAGIAS
function carregarListaMagias(idPerfil) {
        $.ajax({
            type: "GET",
            url: "/api/magia/listar",
            success: function (data) {
                exibirListaMagiasNoIndex(data, idPerfil);
            },
            error: function (error) {
                console.error("Erro ao carregar lista de perfis: ", error);
            }
        });
    }

function exibirListaMagiasNoIndex(magias, idPerfilSelected) {
    var magiaContainer = $("#magiaContainer");
    magiaContainer.empty();

    magias.sort((a, b) => {
        const nomeA = a.nomeMagia ? a.nomeMagia.toLowerCase() : '';
        const nomeB = b.nomeMagia ? b.nomeMagia.toLowerCase() : '';
        return nomeA.localeCompare(nomeB);
    });

    $.ajax({
        type: "GET",
        url: "/api/magiaFavoritada/listar",
        success: function (data) {
            var filteredMagias = data.filter(function (magiaFavoritada) {
                return String(magiaFavoritada.perfil.idPerfil) === String(idPerfilSelected);
            });
              // Use console.table para melhor visualização
            
            magias.forEach(function (magia) {
                var isFavorita = isMagiaFavoritada(magia.idMagia, filteredMagias);                
                var coracaoHtml = isFavorita ? '<i class="fas fa-heart favorito" title="Desfavoritar"></i>' : '<i class="far fa-heart" title="Favoritar"></i>';
                
                var magiaElement = $("<div>")
                    .addClass("part part1")
                    .append(
                        $("<div>")
                            .addClass("title-section")
                            .append(
                                $("<div>")
                                    .addClass("titulo")
                                    .text(magia.nomeMagia),
                                $("<div>")
                                    .addClass("icons")
                                    .append(
                                        $("<a>")
                                            .attr("href", "#")
                                            .attr("id", "favorito")
                                            .attr("title", isFavorita ? "Desfavoritar" : "Favoritar")
                                            .data("magia-id", magia.idMagia)
                                            .data("magiaFavoritada-id", isFavorita ? getMagiaFavoritadaId(magia.idMagia, filteredMagias) : null)
                                            .on("click", toggleFavorito)
                                            .append(
                                                coracaoHtml
                                            ),
                                        $("<a>")
                                            .attr("href", "#")
                                            .attr("id", "infoContent")
                                            .attr("title", "Detalhes")
                                            .on("click", function () {
                                                detalhesMagia(magia, 2);
                                                $('#part2').toggle();
                                            })
                                            .append(
                                                $("<i>")
                                                    .addClass("fas fa-info-circle")
                                            )
                                    )
                            ),
                        $("<div>")
                            .addClass("descricao")
                            .text(magia.nivel + "° nível de encantamento"),
                        $("<div>")
                            .addClass("title-border")
                    );
                magiaContainer.append(magiaElement);
            });
        },
        error: function (error) {
            console.error("Erro ao carregar lista de magias: ", error);
        }
    });
}






// REST API MAGIAS FAVORITADAS
function getMagiaFavoritadaId(magiaId, magiasFavoritadas) {
    var magiaFavoritada = magiasFavoritadas.find(function (mf) {
        return mf.magia.idMagia === magiaId;
    });

    return magiaFavoritada ? magiaFavoritada.idMagiaFavoritada : null;
}

function isMagiaFavoritada(magiaId, filteredMagias) {
    return filteredMagias.some(function (magiaFavoritada) {
        return magiaFavoritada.magia.idMagia === magiaId;
    });
}

function detalhesMagia(magia, x) {
    var part2 = $("#part"+x);
    part2.empty();

    var part2 = $("<div>")
        .addClass("rectangle")
        .attr("id", "rectangle")
        .append(
            $("<div>")
                .addClass("rectangle-inner")
                .append(
                    $("<div>")
                        .addClass("info")
                        .append(
                            $("<div>")
                                .css("font-size", "21px")
                                .text(magia.nomeMagia),
                            $("<div>")
                                .append("<em>" + magia.nivel + "º nível de encantamento</em>"),
                            $("<div>")
                                .append("<b>Tempo De Conjuração:</b><span> " + magia.tempConjuarcao + "</span>"),
                            $("<div>")
                                .append("<b>Alcance:</b><span> " + magia.alcance + "</span>"),
                            $("<div>")
                                .append("<b>Componentes:</b><span> " + magia.componentes + "</span>"),
                            $("<div>")
                                .append("<b>Duração:</b><span> " + magia.duracao + "</span>"),
                            $("<div>")
                                .css("font-size", "15px")
                                .text(magia.descricao),
                            $("<div>")
                                .append("<b>Fontes:</b><span> " + magia.fontes + "</span>")
                        )
                )
        );
    $("#part"+x).append(part2);
}

function carregarListaMagiaFavoritada(idPerfilSelected) {
        $.ajax({
            type: "GET",
            url: "/api/magiaFavoritada/listar",
            success: function (data) {
            var filteredMagias = data.filter(function (magiaFavoritada) {
                return String(magiaFavoritada.perfil.idPerfil) === String(idPerfilSelected);
            });
            exibirMagiaFavoritadaNoIndex(filteredMagias);
            },
            error: function (error) {
                console.error("Erro ao carregar lista de magias: ", error);
            }
        });
    }

function exibirMagiaFavoritadaNoIndex(magias) {
    var magiaSection = $("#magiaSection");
    magiaSection.empty();

    var magiasPorNivel = {};

    magias.forEach(function (magiaFavoritada) {
        var nivel = magiaFavoritada.magia.nivel;

        if (!magiasPorNivel[nivel]) {
            magiasPorNivel[nivel] = [];
        }

        magiasPorNivel[nivel].push(magiaFavoritada);
    });

    for (var nivel in magiasPorNivel) {
        var magiasDoNivel = magiasPorNivel[nivel];

        magiasDoNivel.sort(function (a, b) {
            return a.magia.nomeMagia.localeCompare(b.magia.nomeMagia);
        });

        var nivelElement = $("<div>")
            .addClass("toggle-content nivel-" + nivel)
            .append(
                $("<div>")
                    .addClass("title-section")
                    .append(
                        $("<div>")
                            .addClass("titulo")
                            .text(magiasDoNivel[0].magia.nivel === "0" ? "TRUQUES" : "Nível " + nivel),
                        $("<span>")
                            .addClass("toggle-icon")
                            .html('<i class="fas fa-chevron-down"></i>'),
                        $("<div>")
                            .addClass("icons")
                            .append(
                                $("<input>")
                                    .attr("type", "text")
                                    .addClass("form-control etiqueta-input")
                                    .attr("id", "inputEtiqueta")
                                    .attr("title", "Magias Diárias")
                                    .val(magiasDoNivel[0].magia.nivel)
                            )
                    )
            );

        var magiasContainer = $("<div>").addClass("magias-container");

        magiasDoNivel.forEach(function (magiaFavoritada) {
            var magiaElement = $("<div>")
            .addClass("content-container")
            .attr("data-id-magia", magiaFavoritada.magia.idMagia) 
            .append(
                $("<div>")
                    .addClass("toggle-content nivel-" + magiaFavoritada.magia.nivel)
                    .append(
                        $("<div>")
                            .addClass("title-section")
                            .append(
                                $("<div>")
                                    .addClass("titulo")
                                    .text(magiaFavoritada.magia.nomeMagia),
                                $("<div>")
                                    .addClass("icons")
                                    .append(
                                        $("<a>")
                                            .attr("href", "#")
                                            .attr("id", "desfavorito")
                                            .data("magiaFavoritada-id", magiaFavoritada.idMagiaFavoritada)
                                            .attr("title", "Desfavoritar")
                                            .on("click", toggleFavorito)
                                            .append(
                                                $("<i>")
                                                    .addClass("fas fa-heart")
                                                    .attr("id", "heartIcon")
                                          ),
                                        $("<a>")
                                            .attr("th:href", "@{/#}")
                                            .attr("id", "dado")
                                            .attr("title", "Role o dado!")
                                            .css("cursor", "pointer")
                                            .on("click", showDiceModal)
                                            .html('<i class="fas fa-dice"></i>'),
                                        $("<a>")
                                            .attr("th:href", "@{/#}")
                                            .attr("id", "infoContent1")
                                            .attr("title", "Detalhes")
                                            .css("cursor", "pointer")
                                            .on("click", function () {
                                            detalhesMagia(magiaFavoritada.magia, 3);
                                            $('#part3').toggle();
                                            })
                                            .html('<i class="fas fa-info-circle"></i>')
                                    )
                            ),
                        $("<div>")
                            .addClass("descricao")
                            .text(magiaFavoritada.magia.nivel + "° nível de encantamento"),
                        $("<div>")
                            .addClass("desc-border")
                    )
            );

        slotAtual = magiaFavoritada.slotAtual;
        var bolinhas = isBolinhaEmpty(slotAtual);
        
        for (var i = 1; i <= 5; i++) {
            var nomeSemEspacos = magiaFavoritada.magia.nomeMagia.replace(/\s+/g, '_'); // Substituir espaços por underscores
            magiaElement.find(".icons").append(
                $("<a>")
                    .attr("th:href", "@{/#}")
                    .css("cursor", "pointer")
                    .attr("id", "bolinha-" + nomeSemEspacos + '-' + magiaFavoritada.magia.idMagia + '-' + i)
                    .data("id-Bolinha", "bolinha-" + nomeSemEspacos + '-' + magiaFavoritada.magia.idMagia + '-' + i)
                    .data("state", bolinhas [i])
                    .addClass("bolinha")
                    .on("click", function () {
                        var id = $(this).data("id-Bolinha");
                            toggleBolinha(id, magiaFavoritada);
                        })
                    .html(icon = bolinhas [i] ? '<i class="fas fa-circle"></i>' : '<i class="far fa-circle"></i>')
            );
        }
            magiasContainer.append(magiaElement);
        });
        nivelElement.append(magiasContainer);
        magiaSection.append(nivelElement);
        nivelElement.append("<hr style='margin: 20px 0; border-top: 1px solid #ccc;' class='grupo-separator'>");
    }
}


//BOLINHAS
var bolinhas = [];
function isBolinhaEmpty(slotAtual){
     for (var i = 1; i <= 5; i++) {
         if (i <= slotAtual){
            bolinhas [i] = true; 
         } else {
            bolinhas [i] = false; 
         }
     } 
     return bolinhas;
}

function toggleBolinha(id, magiaFavoritada) {
    var elemento = $("#" + id);    
    var svgElemento = elemento.find("svg");

    if (svgElemento.length > 0) {
        var isCheia = elemento.data("state");
        
        svgElemento.toggleClass("far", isCheia);
        svgElemento.toggleClass("fas", !isCheia);

        elemento.data("state", !isCheia);
        
        slotAtual =  magiaFavoritada.slotAtual;
        
        console.log(slotAtual);
        
        slotAtual = isCheia ? slotAtual-1 : slotAtual+1; 
        if (slotAtual <= 0 ) {
            slotAtual = 0;
        }else if (slotAtual >= 5){
            slotAtual = 5;                
        }
        atualizarSlotAtualNoBanco(magiaFavoritada.idMagiaFavoritada, magiaFavoritada, slotAtual);  
        console.log("Estado alterado para:", isCheia ? "cheia" : "vazia");
    } else {
        console.log("Elemento SVG não encontrado com o ID:", id);
    }
      console.log( magiaFavoritada.idMagiaFavoritada, slotAtual);    
}

function atualizarSlotAtualNoBanco(id, magiaFavoritada, novoSlotAtual) {                     
        var magiaFavoritadaAtualizada = {
            magia: {
                idMagia: magiaFavoritada.magia.idMagia
            },
            usuario: {
                idUsuario: magiaFavoritada.usuario.idUsuario
            },
            perfil: {
                idPerfil: idPerfilSelected
            },
            slotAtual: novoSlotAtual
        };

        $.ajax({
            url: "/api/magiaFavoritada/atualizar/" + id,
            type: "PUT",
            contentType: "application/json", 
            data: JSON.stringify(magiaFavoritadaAtualizada ),
            success: function (data) {
                console.log("Slot atual atualizado:");
                $('#favoritasBtn').click();
            },
            error: function(error) {
                console.error("Erro ao atualizar o slot atual:", error);
            }
        });
}

// DADO
  function showDiceModal() {
    $('#diceModal').modal('show');
  }

  function rollDice() {
    const diceValue = document.getElementById('diceSelect').value;
    const result = Math.floor(Math.random() * diceValue) + 1;
    const resultElement = document.getElementById('result');
    resultElement.innerHTML = `Resultado: <span class="badge badge-warning">${result}</span>`;
  }
 
//DELETE MODAL
$(document).ready(function () {        
        $('#btnDelete').click(function () {
            deletePerfil();
        });
});

//MODAL
function exibirModal(conteudo) {
    $("#modalContentLabel").text(conteudo);
    $("#modal").modal("show");
}

//FAVORITAR
function toggleFavorito(event) {
    event.preventDefault();
    var magiaId = $(event.currentTarget).data('magia-id');
    var magiaFavoritadaId = $(event.currentTarget).data('magiaFavoritada-id');
      console.log(magiaFavoritadaId);  
    if (magiaFavoritadaId !== undefined && magiaFavoritadaId !== null){
        isFavorita = true;
    }else {
        isFavorita = false;
    }
    
    if (idPerfilSelected !== null) {

        var usuario = 1; 
                     
        var magiaFavoritada = {
            magia: {
                idMagia: magiaId
            },
            usuario: {
                idUsuario: usuario
            },
            perfil: {
                idPerfil: idPerfilSelected
            },
            slotAtual: 0 
        };

        var url = isFavorita ? '/api/magiaFavoritada/excluir/'+ magiaFavoritadaId : '/api/magiaFavoritada/criar';
        var type = isFavorita ? 'DELETE' : 'POST';
                console.log(url);
        $.ajax({
            type: type,
            url: url,
            contentType: 'application/json',
            data: JSON.stringify(magiaFavoritada),
            success: function (data) {
                exibirModal('Magia favoritada atualizada com sucesso!');
                if (isFavoritasSelected) {
                    $('#favoritasBtn').click();
                    carregarListaMagias(idPerfilSelected);
                } else {
                    carregarListaMagias(idPerfilSelected);
                }
            },
            error: function (error) {
                console.error('Erro ao atualizar magia favoritada:', error);
            }
        });
    } else {
        exibirModal("Por favor, selecione um perfil antes de selecionar uma magia.");
    }
}




