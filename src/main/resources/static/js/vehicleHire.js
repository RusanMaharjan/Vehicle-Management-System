$('document').ready(function() {	
	$('.table .btn-primary').on('click',function(event){		
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(vehicleHire, status){
			$('#idEdit').val(vehicleHire.id);
			$('#ddlVehicleEdit').val(vehicleHire.vehicleid);
			$('#ddlClientEdit').val(vehicleHire.clientid);
			$('#remarksEdit').val(vehicleHire.remarks);
			
			//create a date variable and extract only the date part of the field
			var dateOut = vehicleHire.dateOut.substr(0, 10);
			var dateIn = vehicleHire.dateIn.substr(0, 10);
			
			$('#dateOutEdit').val(vehicleHire.dateOut);
			$('#dateInEdit').val(vehicleHire.dateIn);
			$('#timeOutEdit').val(vehicleHire.timeOut);
			$('#timeInEdit').val(vehicleHire.timeIn);
			$('#ddlLocationEdit').val(vehicleHire.locationid);
			$('#priceEdit').val(vehicleHire.price);
		});			
		$('#editModal').modal();		
	});
	
	$('.table #detailsButton').on('click',function(event) {
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(vehicleHire, status){
			$('#idEdit').val(vehicleHire.id);
			$('#ddlVehicleEdit').val(vehicleHire.vehicleid);
			$('#ddlClientEdit').val(vehicleHire.clientid);
			$('#remarksEdit').val(vehicleHire.remarks);
			
			//create a date variable and extract only the date part of the field
			var dateOut = vehicleHire.dateOut.substr(0, 10);
			var dateIn = vehicleHire.dateIn.substr(0, 10);
			
			$('#dateOutEdit').val(vehicleHire.dateOut);
			$('#dateInEdit').val(vehicleHire.dateIn);
			$('#timeOutEdit').val(vehicleHire.timeOut);
			$('#timeInEdit').val(vehicleHire.timeIn);
			$('#ddlLocationEdit').val(vehicleHire.locationid);
			$('#priceEdit').val(vehicleHire.price);
			$('#lastModifiedByDetails').val(vehicleHire.lastModifiedBy);
			$('#lastModifiedDateDetails').val(vehicleHire.lastModifiedDate.substr(0,19).replace("T", " "));
		});			
		$('#detailsModal').modal();		
	});	
	
	$('.table #deleteButton').on('click',function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$('#deleteModal #confirmDeleteButton').attr('href', href);
		$('#deleteModal').modal();		
	});	
});