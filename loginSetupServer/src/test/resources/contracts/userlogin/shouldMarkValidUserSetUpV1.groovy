package contracts

org.springframework.cloud.contract.spec.Contract.make {
	request {
		method 'PUT'
		url '/userlogin/v1'
		body([
			   username: 'cloudnativemeetup',
			   password: '123',
			   authcode: '123'
		])
		headers {
			contentType('application/json')
		}
	}
	response {
		status 200
		body([
			   userLoginCheckStatus : 'OK',
			   rejectionReason: 'NO_REASON'
		])
		headers {
			contentType('application/json')
		}
	}
}
