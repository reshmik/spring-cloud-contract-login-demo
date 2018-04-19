package contracts.customerprofileservice

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'PUT'
        url '/customerprofileservice'
        body([
                username: 'reshmi',
                password: '123'		])
        headers {
            contentType('application/json')
        }
    }
    response {
        status 200
        body([
                userLoginCheckStatus : 'GOLD',
                points: 50000
        ])
        headers {
            contentType('application/json')
        }
    }
}
