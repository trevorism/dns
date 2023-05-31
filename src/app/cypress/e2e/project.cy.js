describe('project home page', () => {
    it('passes', () => {
        cy.visit('https://project.trevorism.com')
        cy.get('body').should('contain.text', '/ping')
    })
})