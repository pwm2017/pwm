const $studentItem = $('.student-item');
const $page = $('.page');
const $pagination = $('.pagination');
const $paginationList = $('.pagination__list');
const $studentSearch = $('.student__search');
const itemTotal = 10;

// hide all 
function hideAll() {
  $studentItem.hide();
}

hideAll();

// display first 10
function displayRange(a,b) {
  hideAll();
  // display 0 - 1 students
  $studentItem.slice(a,b).fadeIn();
  
}

displayRange(0, itemTotal);

// create pagination links
let pagination = '';
for(var i = 0; i <= $studentItem.length / 10 - 1; i ++) {
  pagination += `
    <li><span class ="pagination__num">${i}</span></li>
`;
}
$paginationList.append(pagination);
// click on pagination num
// pass into display range
// calc and show range
$('body').on('click', '.pagination__num', function () {

  hideAll();
  
  // get text number 1 - 5
  // get ranges for start and end
  let paginationText = Number($(this).text());
  let startFrom = paginationText * itemTotal + paginationText;
  let end = paginationText * itemTotal + paginationText + itemTotal;
  
  // display ranges
  displayRange(startFrom, end);
   
});


$studentSearch.on('input', function () {

 hideAll();
  
  $studentItem.each(function() {
    $(this).removeClass("result");
    
  });
  
  
    // value of searched
    var text = $(this).val().toLowerCase();
    // results of search
    var results = $("ul.student-list li:contains('" + text.toLowerCase() + "')");
  
     results.addClass("result");
      
      
  // if student has result class 
  // dispaly
  // else hide
  
  
  if($studentItem.hasClass('result')) {
      $('.result').show();
      $studentItem.removeClass('result');
      
     } 

 
});

$studentSearch.keyup(function()
{
     if (!this.value) {
       hideAll();
       displayRange(0, itemTotal);
    }

});