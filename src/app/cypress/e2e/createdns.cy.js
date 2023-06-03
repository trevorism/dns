describe('creating a new DNS record', () => {
    it('runs', () => {
        cy.login()
        cy.visit('https://dcc.secureserver.net/control/TREVORISM.COM/dns')
        cy.get('#dnsAddNewRecord').click()
        cy.get('#dnsRecordIdDropdown-control-menu > .dropdown-text').click()
        cy.get('.dropdown-list > [value="'+ Cypress.env('data').type +'"]').click()
        cy.get('#nameDnsFieldInput').type(Cypress.env('data').host)
        cy.get('#dataDnsFieldInput').type(Cypress.env('data').pointsTo)
        cy.get('.mb-5 > .d-flex > .ux-button-primary').click()
        cy.get("#genericSuccessGrowl").should('have.text', 'Success')
    })
})