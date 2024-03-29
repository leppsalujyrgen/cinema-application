window.onload = function() {
    // Get URL query parameters
    var queryParams = new URLSearchParams(window.location.search);
    
    // Get genre and age restriction values from query parameters
    var genre = queryParams.get('genre');
    var ageRestriction = queryParams.get('ageRestriction');
    
    // Set selected genre option
    var genreSelect = document.getElementById("genreSelect");
    if (genre!="") {
        for (var i = 0; i < genreSelect.options.length; i++) {
            if (genreSelect.options[i].text === genre) {
                genreSelect.selectedIndex = i;
                break;
            }
        }
    }
    
    // Set selected age restriction option
    var ageRestrictionSelect = document.getElementById("ageRestrictionSelect");
    if (ageRestriction!="") {
		for (var i = 0; i < ageRestrictionSelect.options.length; i++) {
            if (ageRestrictionSelect.options[i].value === ageRestriction) {
                ageRestrictionSelect.selectedIndex = i;
                break;
            }
        }
    }
};


function applyMovieFilters() {
    // Get selected genre and age restriction values
    var genre = document.getElementById("genreSelect").value;
    var ageRestriction = document.getElementById("ageRestrictionSelect").value;
    
    // Construct query parameters
    var queryParams = new URLSearchParams();
    if (genre) 
    	queryParams.append('genre', genre);
    if (ageRestriction)
    	queryParams.append('ageRestriction', ageRestriction);
    
    // Construct URL with query parameters
    var currentUrl = "/";
    var urlWithParams = currentUrl.split('?')[0] + '?' + queryParams.toString();
	
	window.location.href = urlWithParams;
}