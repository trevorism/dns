describe('creating a dns entry', () => {
    it('passes', () => {
        cy.visit('https://dns.project.trevorism.com/')
        cy.title().should('equal', 'Trevorism')
    })
})