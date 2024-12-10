import java.sql.;

public class LoginDAO {
    private Connection connection;

    // Método para conectar ao banco de dados
    public void conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/loginjava", "root", "");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para validar o login
    public boolean validarLogin(String usuario, String senha) {
        boolean usuarioValido = false;
        String sql = SELECT FROM usuarios WHERE usuario = ? AND senha = ?;

        try (PreparedStatement pst = connection.prepareStatement(sql)) {
            pst.setString(1, usuario);
            pst.setString(2, senha);

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                usuarioValido = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuarioValido;
    }
    public void adicionarUsuario(String usuario, String senha) {
        String sql = INSERT INTO usuarios (usuario, senha) VALUES (?, ?);

        try (PreparedStatement pst = connection.prepareStatement(sql)) {
            pst.setString(1, usuario);
            pst.setString(2, senha);
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Fechar a conexão
    public void fechar() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}