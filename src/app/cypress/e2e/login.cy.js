describe('creating a new DNS record', () => {
    it('runs', () => {
        cy.login()
        cy.visit('https://dcc.secureserver.net/control/TREVORISM.COM/dns')
        cy.get('#dnsAddNewRecord').click()
        cy.get('#dnsRecordIdDropdown-control-menu > .dropdown-text').click()
        cy.get('.dropdown-list > [value="txt"]').click()
        cy.get('#nameDnsFieldInput').type('_test_cypress')
        cy.get('#dataDnsFieldInput').type('123456788')
        cy.get('#saveDnsRecord').click()
    })
})