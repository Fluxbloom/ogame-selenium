/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameElements;

/**
 * Klasa oddaje możliwe statusy gracza w podglądzie galaktyki i raportach szpiegowskich
 * @author Piotr Kowalski
 */
public class PlayerActivityStatuses {
        protected PlayerActivityStatuses(String status){
            this.status=status;
        }

        @Override
        public String toString() {
            return "PlayerStatuses{" + "status=" + status + '}';
        }
        
        public String print(){
            return "("+status+")";
        }
        
            static public final PlayerActivityStatuses INACTIVE = new PlayerActivityStatuses("i");
    static public final PlayerActivityStatuses LONG_INACTIVE = new PlayerActivityStatuses("I");
    static public final PlayerActivityStatuses VACATION = new PlayerActivityStatuses("u");
    static public final PlayerActivityStatuses NOOB = new PlayerActivityStatuses("s");
    static public final PlayerActivityStatuses STRONG = new PlayerActivityStatuses("d");
    static public final PlayerActivityStatuses OUTLAW = new PlayerActivityStatuses("o");
    static public final PlayerActivityStatuses BANNED = new PlayerActivityStatuses("g");
    static public final PlayerActivityStatuses HONOUR = new PlayerActivityStatuses("ph");
    static public final PlayerActivityStatuses STARLORD = new PlayerActivityStatuses("starl");
    static public final PlayerActivityStatuses BANDIT = new PlayerActivityStatuses("bandit");
    static public final PlayerActivityStatuses NORMAL = new PlayerActivityStatuses("n");
        
        private String status;
    }
