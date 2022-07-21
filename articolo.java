import java.io.*;

class Articolo implements Serializable
{
  private String descr; /* descrizione */
  private int num;      /* numero di pezzi presenti */
  public Articolo(String d)  {  descr = d; num = 0;  }  
  public int numeroPezzi() {  return num;  }
  public String descrizione() {  return descr;  }
  /* le seguenti ritornano true se tutto ok, altrimenti non fanno
     nulla e ritornano false */
  public boolean diminuisci(int n)
  {  if ((n>0)&&(num>=n)) {  num -= n; return true; } else return false;  }
  public boolean aumenta(int n)
  {  if (n>0) {  num += n; return true; } else return false;  }
}
