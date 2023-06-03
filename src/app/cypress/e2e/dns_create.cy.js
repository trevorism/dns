describe('a DNS record', () => {
    it('creates', () => {
        cy.login()
        cy.visit('https://dcc.secureserver.net/control/TREVORISM.COM/dns')
        cy.get('#dnsAddNewRecord').click()
        cy.get('#dnsRecordIdDropdown-control-menu > .dropdown-text').click()
        cy.get('.dropdown-list > [value="'+ Cypress.env('type') +'"]').click()
        cy.get('#nameDnsFieldInput').type(Cypress.env('host'))
        cy.get('#dataDnsFieldInput').type(Cypress.env('value'))
        cy.get('.mb-5 > .d-flex > .ux-button-primary').click()
        cy.get("#genericSuccessGrowl").should('have.text', 'Success')
    })
})