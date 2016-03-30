function initSubheader(stickyElem, containerElem) {
  jQuery(document).ready(function(){
    var newStickies = new stickyTitles(stickyElem, containerElem);
    newStickies.load();
    $(containerElem).on("scroll", function() {
      newStickies.scroll();
    });
  });
}

function stickyTitles(stickyElem, containerElem) {
  var stickies = jQuery(stickyElem);
  var container = jQuery(containerElem);
  container.addClass("subheader-container");

  /** Added top holder component **/
  var topHolder = document.createElement("div");
  $(topHolder).addClass("top_holder");
  container.prepend(topHolder);
  this.load = function() {


    stickies.each(function(){

      var thisSticky = jQuery(this).wrap('<div class="followWrap" />');
      thisSticky.parent().height(thisSticky.outerHeight());

      jQuery.data(thisSticky[0], 'pos', thisSticky.position().top);

    });
  }

  this.scroll = function() {
    $(topHolder).css('top',  container.scrollTop());
    $(topHolder).addClass("z-depth-1");
    stickies.each(function(i){
      var thisSticky = jQuery(this),
          nextSticky = stickies.eq(i+1),
          prevSticky = stickies.eq(i-1),
          pos = jQuery.data(thisSticky[0], 'pos');

      if(container.scrollTop() == 0){
        $(topHolder).hide();
      }else{
        $(topHolder).show();
      }

      if (pos <= container.scrollTop()) {
        $(topHolder).html('');
        thisSticky.clone().appendTo($(topHolder));

      } else {
        thisSticky.removeAttr('style').show();
        if (prevSticky.length > 0 && container.offset().top <= jQuery.data(thisSticky[0], 'pos')  - prevSticky.outerHeight()) {
          prevSticky.removeClass("absolute").removeAttr("style");
        }

      }
    });
  }
}