package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
	request {
		method 'PUT'
		url '/weblogin'
		body([
				username: 'springone',
				password: '321'		])
		headers {
			contentType('application/json')
		}
	}
    response {
        status 200
        body([
                userLoginCheckStatus : 'NOT_OKAY',
                rejectionReason: 'INCORRECT_PASSWORD'
        ])
        headers {
            contentType('application/json')
        }
    }
}
