package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
	request {
		method 'PUT'
		url '/weblogin'
		body([
			   username: 'cfsummit',
			   password: '123'		])
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
