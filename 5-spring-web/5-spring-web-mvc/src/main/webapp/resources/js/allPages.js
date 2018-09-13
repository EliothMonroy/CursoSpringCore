String.prototype.startsWith = function(str) {
  return this.indexOf(str) == 0;
};

String.prototype.contains = function(str) {
  return this.indexOf(str) !== -1;
};

(function($) {
  $.fn.clickToggle = function(func1, func2) {
    var funcs = [func1, func2];
    this.data('toggleclicked', 0);
    this.click(function() {
      var data = $(this).data();
      var tc = data.toggleclicked;
      $.proxy(funcs[tc], this)();
      data.toggleclicked = (tc + 1) % 2;
    });
    return this;
  };
}(jQuery));

util = {
  doAjax: function(url, type, data, callback_ok, callback_error) {
    $.ajax({
      'url': url,
      'data': data,
      'dataType': 'json',
      'type': type,
      'success': function(r) {
        callback_ok(r);
      },
      'error': function(r) {
        callback_error(JSON.parse(r.responseText));
      }
    });
  },

  showCommandMensaje: function(mensaje, hideCommandMensaje, cb) {
    if (typeof hideCommandMensaje === 'undefined') {
      hideCommandMensaje = false;
    }

    $("#command-mensaje").hide().html(mensaje).show('fast', function() {
      var $this = $(this);
            
      if (hideCommandMensaje) {
        setTimeout(function() {
          $this.hide('fast', function() {
            $this.empty()
          });
        }, 3000);
      }
    });

    if (typeof cb !== 'undefined') {
      cb($("#command-mensaje"));
    }
  }
};

$(document).ready(function(event) {

  var theme = $.cookies.get('theme');

  if (theme !== undefined) {
    $('head').append('<link rel="stylesheet" type="text/css" href="resources/css/theme' + theme + '.css">');
  }

  $('a[data-theme]').each(function(i, v) {

    $(this).on('click', function(event) {
      event.preventDefault();

      var theme = $(this).attr('data-theme');

      $.cookies.set('theme', theme);

      $('head').append('<link rel="stylesheet" type="text/css" href="resources/css/theme' + theme + '.css">');
    });
  });

  $("div#topmenu ul li a[data-seccion='" + currentSecc + "']").parent().addClass('current');

  $("a[href='#']").each(function(i, v) {
    $(this).on('click', function(event) {
      event.preventDefault();
    });
  });

  $("input[type=button][data-accion=regresar]").each(function(i, v) {
    $(this).on('click', function(event) {
      event.preventDefault();
      window.history.back();
    });
  });

  $("a[data-seccion=logout]").each(function(i, v) {
    var $this = $(this);
    $this.on('click', function(event) {
      event.preventDefault();

      swal({
        title: "¿Do you want logout?",
        // text: "You will not be able to recover this customer and theirs
        // Accounts!",
        type: "warning",
        showCancelButton: true,
        confirmButtonColor: "#DD6B55",
        confirmButtonText: "Yes, logout me  !",
        closeOnConfirm: true
      }, function() {
        document.location.href = $this.attr("data-href-url");
      });

    });
  });

});