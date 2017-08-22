package contracts

org.springframework.cloud.contract.spec.Contract.make {
	request {
		method 'PUT'
		url '/userlogin'
		body([
			   username: 'springdays1',
			   password: '123',
			   authcode: value(consumer(regex('[0-9][0-9][0-9]')))
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
