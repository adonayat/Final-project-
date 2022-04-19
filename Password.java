public class Password {
    private String password;

    public void setPassword(String securityCode)
    {
        password = securityCode;
    }
    public boolean isInputCorrect(String code)
    {
        if (code.equals(password))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public String getPassword()
    {
        return password;
    }
}
