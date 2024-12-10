public class Main {
    public static void main(String[] args) {
        LoginDAO loginDAO = new LoginDAO();
        loginDAO.conectar();

        loginDAO.adicionarUsuario("usuario1", "senha123");

        boolean loginValido = loginDAO.validarLogin("usuario1", "senha123");
        if (loginValido) {
            System.out.println("Login válido!");
        } else {
            System.out.println("Login inválido!");
        }
        
        loginDAO.fechar();
    }
}