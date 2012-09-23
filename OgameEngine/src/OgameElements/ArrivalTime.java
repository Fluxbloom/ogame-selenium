/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameElements;

/**
 * Klasa odpowiada parze danych pochodzących z nadania floty, tj. czasu do powrotu oraz jego godziny
 * @author Piotr Kowalski
 */
public class ArrivalTime {

    /**
     * Domyślny konstruktor umieszczający czas powrotu oraz czas do lotu
     * @param arrivalTime czas dotarcia dla danej floty
     * @param flyingTime czas lotu floty
     */
    public ArrivalTime(Time arrivalTime, TimePeriod flyingTime) {
        this.returnTime = arrivalTime;
        this.flyingTime = flyingTime;
    }
    /**
     * Pobiera czas lotu 
     * @return czas lotu jako objekt TimePeriod
     */
    public TimePeriod getFlyingTime() {
        return flyingTime;
    }
    /**
     * Godzina dotarcia do celu 
     * @return czas do dotarcia do celu
     */
    public Time getArrivalTime() {
        return returnTime;
    }
    
    private Time returnTime;
    private TimePeriod flyingTime;
}
