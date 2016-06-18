$ ->
  $.get "/matches", (matches) ->
    $.each matches, (index, match) ->
      $("#matches").append "<div class='thumbnail text-center col-md-4 col-md-offset-1'>"+
          "<a href='/delete_match/" + match.id + "'>X<a/>"+
          "<h3 class='card-title'>" + match.localTeam + " vs " + match.awayTeam+"</h3>"+
          "<h1 class='card-title'>" + match.goalsLocalTeam + "     -     " + match.goalsAwayTeam+"</h1>"+
          "<h4 class='card-title'>Stadium: " + match.stadium + "</h4>"+
          "</h4></div>"