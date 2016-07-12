Employee = {
	
	clearEmployeeForm : function(){
		$(':input').not(':submit,:button').val('');
	},
	
	hideAllMessage : function(){
		$('#firstNameMissing,#firstNameInvalid,#lastNameInvalid').hide();
		$('#designationMissing,#designationInvalid,#companyNameMissing').hide();
		$('#companyNameInvalid').hide();
	},
	
	validateEmployee : function(){
		$('#addEmployee,#updateEmployee').click(function(){
			// Reading all values
			var firstName 	= $('#firstName').val();
			var lastName 	= $('#lastName').val();
			var designation = $('#designation').val();
			var companyName = $('#companyName').val();
			
			// Regular Expression
			var firstName_regex 	= /^[^\s][a-zA-Z]+([\s]?[a-zA-Z]+)*[^\s]+$/;
			var lastName_regex 		= /^[^\s][a-zA-Z]+([\s]?[a-zA-Z]+)*[^\s]+$/;
			var designation_regex 	= /^[^\s][a-zA-Z]+([\s]?[a-zA-Z]+)*[^\s]+$/;
			var companyName_regex 	= /^[^\s][a-zA-Z]+([\s]?[a-zA-Z]+)*[^\s]+$/;
			
			if(firstName == "" || firstName.length == 0 || firstName == undefined){
				Employee.hideAllMessage();
				$('#firstNameMissing').show();
				return false;
			}
			else if(!firstName.match(firstName_regex)){
				Employee.hideAllMessage();
				$('#firstNameInvalid').show();
				return false;
			}
			else if(!lastName.match(lastName_regex) && lastName.length > 0){
				Employee.hideAllMessage();
				$('#lastNameInvalid').show();
				return false;
			}
			else if(designation == "" || designation.length == 0 || designation == undefined){
				Employee.hideAllMessage();
				$('#designationMissing').show();
				return false;
			}
			else if(!designation.match(designation_regex)){
				Employee.hideAllMessage();
				$('#designationInvalid').show();
				return false;
			}
			else if(companyName == "" || companyName.length == 0 || companyName == undefined){
				Employee.hideAllMessage();
				$('#companyNameMissing').show();
				return false;
			}
			else if(!companyName.match(companyName_regex)){
				Employee.hideAllMessage();
				$('#companyNameInvalid').show();
				return false;
			}
		});
	},
}