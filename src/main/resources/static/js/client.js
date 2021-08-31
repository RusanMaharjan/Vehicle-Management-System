$('document').ready(function() {
	
	$('.table .btn-primary').on('click',function(event){		
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(client, status){
			$('#txtAddressEdit').val(client.address);
			$('#txtCityEdit').val(client.city);
			$('#ddlCountryEdit').val(client.countryid);
			$('#txtDetailsEdit').val(client.details);
			$('#txtEmailEdit').val(client.email);
			$('#txtIdEdit').val(client.id);
			$('#txtMobileEdit').val(client.mobile);
			$('#txtNameEdit').val(client.name);	
			$('#txtPhoneEdit').val(client.phone);			
			$('#ddlStateEdit').val(client.stateid);	
			$('#txtWebsiteEdit').val(client.website);
		});			
		$('#editModal').modal();		
	});
	
	$('.table #detailsButton').on('click',function(event) {
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(client, status){
			$('#txtAddressDetails').val(client.address);
			$('#txtCityDetails').val(client.city);
			$('#ddlCountryDetails').val(client.countryid);
			$('#txtDetailsDetails').val(client.details);
			$('#txtEmailDetails').val(client.email);
			$('#txtIdDetails').val(client.id);
			$('#txtMobileDetails').val(client.mobile);
			$('#txtNameDetails').val(client.name);	
			$('#txtPhoneDetails').val(client.phone);			
			$('#ddlStateDetails').val(client.stateid);	
			$('#txtWebsiteDetails').val(client.website);
			$('#lastModifiedByDetails').val(country.lastModifiedBy);
			//$('#lastModifiedDateDetails').val(country.lastModifiedDate.substr(0,19).replace("T", " "));
		});			
		$('#detailsModal').modal();		
	});	
	
	$('.table #deleteButton').on('click',function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$('#deleteModal #delRef').attr('href', href);
		$('#deleteModal').modal();		
	});	
});