import java.util.*;
import java.io.*;

public class Magazzino implements Serializable
{
    private int capacita;        // quanti articoli puo' contenere
    private Articolo[] articoli; // array degli articoli presenti

    /* COSTRUTTORI */

    Magazzino()
    {  capacita = 100; articoli = new Articolo[100];  }

    Magazzino(int cap)
    {
      capacita = (cap>=100) ? cap : 100;
      articoli = new Articolo[capacita];
    }

    /* ALTRI METODI */

    /* restituisce articolo dato il suo codice */
    Articolo articoloPerCodice(int cod)
    {  
       if ((cod<0) || (cod>capacita)) return null;
       else return articoli[cod];
    }

    /* registra un nuovo articolo */
    public boolean nuovoArticolo(String s)
    {
       Articolo nuovo = new Articolo(s);
       int i;
       for (i=0; i<capacita; i++)
       {
         if (articoli[i]==null) // trovato un posto libero
         {  
           articoli[i] = nuovo;
           return true;
         }
       }
       return false; // non c'era un posto libero
    }

    /* fa entrare nel magazzino p pezzi dell'articolo */
    public void entraArticolo(int p, int cod) throws Exception
    {
      if (p < 0)
        throw new Exception("Movimento entrata: numero di pezzi negativo");
      Articolo presente = articoli[cod];
      if (presente == null)
        throw new Exception("Movimento entrata: codice articolo non valido");
      else
        presente.aumenta(p);
    }

    /* fa uscire dal magazzino p pezzi dell'articolo, devono esserne
       presenti almeno p */
    public void esceArticolo(int p, int cod) throws Exception
    {
      if (p < 0)
        throw new Exception("Movimento uscita: numero di pezzi negativo");
      Articolo presente = articoli[cod];
      if (presente == null)
        throw new Exception("Movimento uscita: codice articolo non valido");
      else
      {
        if (!presente.diminuisci(p))
          throw new Exception("Movimento uscita: numero di pezzi eccessivo");
      }
    }

    /* depenna articolo dal magazzino, di quell'articolo devono essere
       presenti zero pezzi */
    public void scaricaArticolo(int cod) throws Exception
    {
      Articolo presente = articoli[cod];
      if (presente == null)
        throw new Exception("Scarica articolo: codice articolo non valido");
      else if (presente.numeroPezzi()>0)
        throw new Exception("Scarica articolo: articolo ha pezzi presenti");
      else 
        articoli[cod] = null;
    }

}
