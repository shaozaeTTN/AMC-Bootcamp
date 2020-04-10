(function(window, $) {
  'use strict';
$.validator.register({
  selector: 'input[data-validation="minlength"]',
  validate: function(el) {
    var min = parseInt(el.data("minlength"));
    var value = $(el).val();
    var length = value.length;

    if (length < min) {
      return "Subheading should have minimum " + min + " characters. It currently has " + length + ".";
    }
  }
  });
})(window, jQuery);
