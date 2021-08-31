
$('document').ready(function(){
	$('.table #editButton').on('click', function(event){
		event.preventDefault();
		var href = $(this).attr('href');
		$.get(href, function(supplier, status){
			$('#txtIdEdit').val(supplier.id);
			$('#txtNameEdit').val(supplier.name);
			$('#txtAddressEdit').val(supplier.address);
			$('#txtCityEdit').val(supplier.city);
			$('#ddlCountryEdit').val(supplier.countryid);
			$('#ddlStateEdit').val(supplier.stateid);
			$('#txtEmailEdit').val(supplier.email);
			$('#txtPhoneEdit').val(supplier.phone);
			$('#txtMobileEdit').val(supplier.mobile);
			$('#txtWebsiteEdit').val(supplier.website);
			$('#txtDetailsEdit').val(supplier.details);
		});
		$('#editModal').modal();
	});
	
	$('.table #detailsButton').on('click', function(event){
		event.preventDefault();
		var href = $(this).attr('href');
		$.get(href, function(supplier, status){
			$('#txtIdDetails').val(supplier.id);
			$('#txtNameDetails').val(supplier.name);
			$('#txtAddressDetails').val(supplier.address);
			$('#txtCityDetails').val(supplier.city);
			$('#ddlCountryDetails').val(supplier.countryid);
			$('#ddlStateDetails').val(supplier.stateid);
			$('#txtEmailDetails').val(supplier.email);
			$('#txtPhoneDetails').val(supplier.phone);
			$('#txtMobileDetails').val(supplier.mobile);
			$('#txtWebsiteDetails').val(supplier.website);
			$('#txtDetailsDetails').val(supplier.details);
		});
		$('#detailsModal').modal();
	});
	
	$('.table #deleteButton').on('click', function(event){
		event.preventDefault();
		var href = $(this).attr('href');
		$('#deleteModal #delSupplier').attr('href', href);
		$('#deleteModal').modal();
	});
	
});
