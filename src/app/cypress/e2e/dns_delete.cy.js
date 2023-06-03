describe('an existing DNS record on the first row', () => {
    it('deletes', () => {
        cy.login()
        cy.visit('https://dcc.secureserver.net/control/TREVORISM.COM/dns')
        cy.get('.hidden-sm-down > .d-flex > :nth-child(1) > #dnsTableFilter > #dnsTableFilter-control-menu > .dropdown-text > .ux-button').click()
        cy.get('.hidden-sm-down > .d-flex > :nth-child(1) > #dnsTableFilter > .dropdown-menu > #dnsTableFilter-menu > .dropdown-list').find('input[name="'+ Cypress.env('type') +'"]').click()
        cy.get('.hidden-sm-down > .d-flex > :nth-child(1) > #dnsTableFilter > .dropdown-menu > #dnsTableFilter-menu > .dropdown-list > .filter-action-btn > .ux-sibling-set > .ux-text > .ux-button-primary').click()
        cy.get('.ux-table').contains('td', Cypress.env('host')).parent().find('.dns-table-checkbox').click()
        cy.get('#dnsBulkDelete').click()
        cy.get("#dnsDeleteRecordModalDelete").click()
        cy.get('.ux-table').should('not.contain', Cypress.env('host'))
    })
})