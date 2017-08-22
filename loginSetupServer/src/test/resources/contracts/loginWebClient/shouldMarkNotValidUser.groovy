
package contracts

org.springframework.cloud.contract.spec.Contract.make {
	request { 
		method 'PUT'
		url '/userlogin'
		body([ 
			   username: 'springdays',
			   password: '321'
		])
		headers {
			contentType('application/json')
		}
	}
	response { 
		status 200 
		body([ 
			   userLoginCheckStatus : 'NOT_OKAY',
			   rejectionReason: 'CONTAINS_SPECIAL_CHARACTER'
		])
		headers {
			contentType('application/json')
		}
	}
}
