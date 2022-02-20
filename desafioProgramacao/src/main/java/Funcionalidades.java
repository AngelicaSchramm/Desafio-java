
import java.util.ArrayList;
import java.util.Arrays;

public class Funcionalidades{
    
    /**
     * Exibe na tela uma escada de * com  base e altura do tamanho do número passado 
     * @param n tamanho de base da escada
     */
    public void escada(int n){
        for(int i=1; i<=n; i++ ){
            for(int c=(n-i); c >= 1; c-- ){
                System.out.print(" ");
            }
            for(int e=i; e>=1; e-- ){
                System.out.print("*");
            }
            
            System.out.println("");
        }
    }

    /**
     * Verifica se a senha satisfaz os seguintes critérios:
     * Possui no mínimo 6 caracteres;
     * Contém no mínimo um digito;
     * Contém no mínimo 1 letra em minúsculo;
     * Contém no mínimo 1 letra em maiúsculo;
     * 
     * @param senha qualquer palavra
     * @return número mínimo de caracteres necessários para tornar a senha forte
     */
    public int senhaForte(String senha){
       
        int maiuscula = 1;
        int minuscula = 1;
        int  numero = 1;
        int especiais = 1;
        char[] caracteres = {'!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '+'};
        
        for(char c : senha.toCharArray()){
            if(c >= 'A' && c <='Z'){
                maiuscula = 0;
            }
            if(c >= 'a' && c <= 'z'){
                minuscula = 0;
            }
            if(c >= '0' && c <= '9'){
                numero = 0;
            }
            for(char e : caracteres){
                if(c == e){
                    especiais = 0;
                }
            }
        }
        
        
        int falta = (maiuscula + minuscula + especiais + numero);
        int faltaTam = 6 - senha.length();
        if (falta < faltaTam){
            falta += faltaTam - falta; 
        }
        return(falta);
    }
    
    /**
     * Cria um array ordenado de substrings dividindo a string recebida em letras conforme a quantidade passada
     * @param palavra qualquer string
     * @param tam quantidade de letras que terá cada item do array
     * @return array ordenado
     */
    public ArrayList retornaArraySort(String palavra, int tam){
        ArrayList<String> novoArr = new ArrayList();
        for(int i = 0; i <= palavra.length(); i++){
            if(i + tam <= palavra.length()){
                char[] a = palavra.substring(i, i+tam).toCharArray();
                Arrays.sort(a);
                String sorted = "";
                for(char letra : a){
                    sorted += String.valueOf(letra);
                }
                
                novoArr.add(sorted);
            }
        }
        
        return novoArr;
    }
    
    /**
     * Verifica se há itens iguais dentro de um array
     * @param arr array de Strings
     * @return retorna a quantidade de itens iguais dentro do array
     */
    public int verificaIguais(ArrayList arr){
        int quant =0;
    
        for(int i=0; i < arr.size()-1; i++){
            for(int e=i+1; e <= arr.size() -1; e++){
                if(arr.get(i).equals(arr.get(e))){
                   quant++;
                }
            }
        }
        return quant;
        
    }
    
    /**
     * verifica a quantidade de anagramas existentes dentro de uma palavra
     * @param palavra qualquer string
     * @return o número de anagramas 
     */
    public int contAnagramas(String palavra){
        int anagramas = 0;
        
        ArrayList arr1 = retornaArraySort(palavra, 1);
        anagramas += verificaIguais(arr1);
        ArrayList arr2 = retornaArraySort(palavra, 2);
        anagramas += verificaIguais(arr2);
        ArrayList arr3 = retornaArraySort(palavra, 3);
        anagramas += verificaIguais(arr3);
                 
        return(anagramas);
    }
}