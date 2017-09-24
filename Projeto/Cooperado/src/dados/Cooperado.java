package dados;

public class Cooperado {
    //Atributos
    private String nome = "";
    private String profissao = "";
    private float horasTrabalhadas = 0;
    private float valorHora = 0;
    
    //Contrutor(es)
    public Cooperado(){}
    
    //Métodos de Cálculos
    public float calcularSalarioLiquido(float horasTrabalhadas, float valorHora, float bonificacao){
        return (horasTrabalhadas * valorHora) + bonificacao;
    }
    
    public float calcularBonificacao(String profissao, float horasTrabalhadas, float valorHora) throws Exception{
        float bonificacao = 0;
        float salario = horasTrabalhadas * valorHora;
        
        switch (profissao) {
            case "Advogado":
            case "Médico":
            case "Engenheiro":
                if (horasTrabalhadas < 300)
                    bonificacao = 0;
                else if (horasTrabalhadas >= 300 && horasTrabalhadas < 500)
                    bonificacao = salario * 0.2f;
                else
                    bonificacao = salario * 0.25f;
                break;
            case "Enfermeiro":
            case "Dentista":
                if (horasTrabalhadas < 250)
                    bonificacao = 0;
                else if (horasTrabalhadas >= 250 && horasTrabalhadas < 400)
                    bonificacao = salario * 0.19f;
                else
                    bonificacao = salario * 0.23f;
                break;
            default:
                throw new Exception ("Profissão do cooperado não permitida!");
        }
        
        return bonificacao;
    }
    
    public float calcularContribuicao(float salarioLiquido, String profissao) throws Exception{
        float contribuicao = 0;
        
        switch (profissao){
            case "Advogado": contribuicao = salarioLiquido * 0.1f; break;
            case "Médico": contribuicao = salarioLiquido * 0.11f; break;
            case "Engenheiro": contribuicao = salarioLiquido * 0.09f; break;
            case "Enfermeiro": contribuicao = salarioLiquido * 0.07f; break;
            case "Dentista": contribuicao = salarioLiquido * 0.08f; break;
            default: throw new Exception ("Profissão do cooperado não permitida!");
        }
        
        return contribuicao;
    }
    
    public float calcularSalarioFinal(float salarioLiquido, float contribuicao){
        return salarioLiquido - contribuicao;
    }
    
    
    //Métodos Acessores e Modificadores

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws Exception{
        char[] n = nome.toCharArray();
        for (int i = 0; i < n.length; i++) {
            if (Character.isDigit(n[i])) // Validação para números
                throw new Exception("Nome inválido! Digite novamente");
            else if (Character.getType(n[i]) == 24) // Validação para símbolos
                throw new Exception("Nome inválido! Digite novamente");
            else if (nome.trim().isEmpty()) // Validação para espaços
                throw new Exception("Nome inválido! Digite novamente");
        }
        this.nome = nome;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) throws Exception{
        char[] n = profissao.toCharArray();
        for (int i = 0; i < n.length; i++) {
            if (Character.isDigit(n[i])) // Validação para números
                throw new Exception("Profissão inválida! Digite novamente");
            else if (Character.getType(n[i]) == 24) // Validação para símbolos
                throw new Exception("Profissão inválida! Digite novamente");
            else if (profissao.trim().isEmpty()) // Validação para espaços
                throw new Exception("Profissão inválida! Digite novamente");
        }
        this.profissao = profissao;
    }

    public float getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public void setHorasTrabalhadas(float horasTrabalhadas) throws Exception {
        if (horasTrabalhadas < 0 || horasTrabalhadas < 160) throw new Exception("Horas trabalhadas inválidas! Digite novamente!");
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public float getValorHora() {
        return valorHora;
    }

    public void setValorHora(float valorHora) throws Exception{
        if (valorHora < 0) throw new Exception("Valor de hora trabalhada inválida! Digite novamente!");
        this.valorHora = valorHora;
    }
    
}
