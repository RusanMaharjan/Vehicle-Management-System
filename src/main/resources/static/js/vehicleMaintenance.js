$('document').ready(function() {	
	$('.table .btn-primary').on('click',function(event){		
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(vehicleMaintenance, status){
			$('#idEdit').val(vehicleMaintenance.id);
			$('#ddlVehicleEdit').val(vehicleMaintenance.vehicleid);
			$('#remarksEdit').val(vehicleMaintenance.remarks);
			
			//create a date variable and extract only the date part of the field
			var startDate = vehicleMaintenance.startDate.substr(0, 10);
			var endDate = vehicleMaintenance.endDate.substr(0, 10);
			
			$('#startDateEdit').val(vehicleMaintenance.startDate);
			$('#endDateEdit').val(vehicleMaintenance.endDate);
			$('#ddlSupplierEdit').val(vehicleMaintenance.supplierid);
			$('#priceEdit').val(vehicleMaintenance.price);
		});			
		$('#editModal').modal();		
	});
	
	$('.table #detailsButton').on('click',function(event) {
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(vehicleMaintenance, status){
			$('#idDetails').val(vehicleMaintenance.id);
			$('#ddlVehicleDetails').val(vehicleMaintenance.vehicleid);
			$('#startDateDetails').val(vehicleMaintenance.startDate);
			$('#remarksDetails').val(vehicleMaintenance.remarks);
			$('#endDateDetails').val(vehicleMaintenance.endDate);
			$('#ddlSupplierDetails').val(vehicleMaintenance.supplierid);
			$('#priceDetails').val(vehicleMaintenance.price);
			$('#lastModifiedByDetails').val(vehicleMaintenance.lastModifiedBy);
			$('#lastModifiedDateDetails').val(vehicleMaintenance.lastModifiedDate.substr(0,19).replace("T", " "));
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