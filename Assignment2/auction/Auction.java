import java.util.*;

/**
 * A simple model of an auction.
 * The auction maintains a list of lots of arbitrary length.
 *
 * @author David J. Barnes and Michael Kolling.
 * @version 2006.03.30
 *
 * @author (of AuctionSkeleton) Lynn Marshall
 * @version 2.0
 * 
 * @author <Abhiram Santhosh>
 * @version <04/10/17>
 * 
 */
public class Auction
{
    /** The list of Lots in this auction. */
    private ArrayList<Lot> lots;

    /** 
     * The number that will be given to the next lot entered
     * into this auction.  Every lot gets a new number, even if some lots have
     * been removed.  (For example, if lot number 3 has been deleted, we don't
     * reuse it.)
     */
    private int nextLotNumber;

    /** 
     * Checks to see if the auction is open
     */
    private boolean auctionOpen = false;

    /**
     * Create a new auction.
     */
    public Auction()
    {

        lots = new ArrayList<Lot>();
        nextLotNumber = 1;
        auctionOpen = true;

    }

    /**
     * This constructor takes
     * an Auction as a parameter.  Provided the auction parameter
     * is closed, the constructor creates a new auction containing
     * the unsold lots of the closed auction.  If the auction parameter
     * is still open or null, this constructor behaves like the
     * default constructor.
     * @param passedAuction takes in an auction
     */
    public Auction (Auction passedAuction){

        if(passedAuction.auctionOpen == false){

            lots = new ArrayList<Lot>();
            //iterate through the passedAuction and see which lots are sold
            //check if highest bid is null, if it is null then the lot hasn't been sold
            for(Lot lot:passedAuction.lots){

                if(lot.getHighestBid() == null){
                    //means its empty
                    lots.add(lot);
                    this.nextLotNumber = passedAuction.nextLotNumber;
                    auctionOpen = true;
                }
            }

        } else {

            lots = new ArrayList<Lot>();
            nextLotNumber = 1;
            auctionOpen = true;   

        }

    }

    /**
     * Enter a new lot into the auction.  Returns false if the
     * auction is not open or if the description is null.
     * 
     * @param description A description of the lot.
     * @return true if the lot has been added.
     */
    public boolean enterLot(String description)
    {
        if(auctionOpen == false || description == null){
            //auction isn't open OR the descriptiion entered is NULL
            return false;
        } else {
            lots.add(new Lot(nextLotNumber, description));
            nextLotNumber++;
            return true;
        }
    }

    /**
     * Show the full list of lots in this auction.
     *
     * Print a blank line first, to make our output look nicer. 
     * If there are no lots, print a message indicating this 
     * 
     */
    public void showLots()

    {

        if (lots.isEmpty()){
            //if the lots are all empty
            System.out.println("There are no lots");

        }

        for(Lot lot : lots) {

            System.out.println();

            if(lot == null){
                //if the specific lot is null, simple failsafe
                System.out.println("There is no lot here");
            } else {
                System.out.println(lot.toString());
            } 
        }
    }

    /**
     * Bid for a lot.
     * Prints a message indicating whether the bid is successful or not.
     *   
     * First print a blank line.  
     * Then print whether or not the bid is successful.
     * If the bid is successful, also print the
     * lot number, high bidder's name, and the bid value.
     * If the bid is not successful, also print the lot number 
     * and high bid (but not the high bidder's name).
     * 
     * Returns false if the auction is closed, the lot doesn't
     * exist, the bidder is null, or the bid was not positive
     * and true otherwise 
     *
     * @param number The lot number being bid for.
     * @param bidder The person bidding for the lot.
     * @param value  The value of the bid.
     * @return boolean will return true if the bid for the lot is the highest bid, will return true if the 
     * bid is not as high as the highest bid
     */
    public boolean bidFor(int lotNumber, Person bidder, long value)
    {   
        //create an ArrayList of l
        ArrayList<Integer> lotnumArrayList = new ArrayList<Integer>();
        if(auctionOpen == false || value <= 0 || bidder == null){
            return false;

        }
        for(Lot lot: lots){    

            //add each lot number to the lotnumArrayList arraylist
            lotnumArrayList.add(lot.getNumber());

        }

        //if the lot number is in the array of lot numbers, let the code continue
        //else return false
        if(lotnumArrayList.contains(lotNumber)){
            for(Lot lot: lots){    

                if(lot.getNumber() == lotNumber){
                    //we have a match on the lotNumber
                    Bid bid = new Bid(bidder,value);
                    boolean successful = lot.bidFor(bid);
                    if(successful){
                        System.out.println("The bid for lot number " +
                            lotNumber + " was successful at " + "$" + bid.getValue() + ", " + bid.getBidder().getName());
                        return true;
                    } else {
                        Bid highestBid = lot.getHighestBid();
                        System.out.println("Lot number: " + lotNumber +
                            " already has a bid of: " + "$" +
                            highestBid.getValue());
                        return true;

                    }

                } 

            }

            return true;

        }else {
            return false;
        }
    }

    /**
     * Return the lot with the given number. 
     * Do not assume that the lots are stored in numerical order.   
     *   
     * Returns null if the lot does not exist.
     *
     * @param lotNumber The number of the lot to return.
     * @return the Lot with the given number
     */
    public Lot getLot(int lotNumber)
    {

        if((lotNumber >= 1) && (lotNumber < nextLotNumber)) {
            //check if the lot number is above 0, and the 
            //lot number is less than the next lot number
            for(Lot lot : lots){

                if(lot.getNumber() == lotNumber){
                    //I have the lot now
                    return lot;

                } 

            }
        } else{
            System.out.println("Lot number: " + lotNumber +
                " does not exist.");
            return null;
        }
        return null;
    }

    /**
     * Closes the auction and prints information on the lots.
     * First print a blank line.  Then for each lot,
     * its number and description are printed.
     * If it did sell, the high bidder and bid value are also printed.  
     * If it didn't sell, that information is printed.
     * 
     * @return boolean true if the auction is sucessfully closed
     *
     */
    public boolean close()
    {

        if(auctionOpen == false){
            return false;
        } else{
            System.out.println();
            for(Lot lot:lots){

                if(lot.getHighestBid() != null){
                    //it sold
                    System.out.println("Lot number " + lot.getNumber() + ", "
                        + lot.getDescription() + ", " +  " has been sold to " + 
                        lot.getHighestBid().getBidder().getName() + " for " + "$" + lot.getHighestBid().getValue());

                } else {
                    System.out.println("Lot number "+ lot.getNumber() + ", " + lot.getDescription() + ", " + 
                        " has not been sold");
                }

            }

            auctionOpen = false;
            return true;
        }

    }

    /**
     * Returns an ArrayList containing all the items that have no bids so far.
     * (or have not sold if the auction has ended).
     * 
     * @param an ArrayList of lots
     * @return an ArrayList of the Lots which currently have no bids
     */
    public ArrayList<Lot> getNoBids()
    {
        ArrayList<Lot> unsoldLots = new ArrayList<Lot>();

        for (Lot lot : lots){

            Bid lotBid = lot.getHighestBid();

            if(lotBid == null){
                unsoldLots.add(lot);
            }

        }
        return unsoldLots;
    }

    /**
     * Remove the lot with the given lot number, as long as the lot has
     * no bids, and the auction is open.  
     * You must use an Iterator object to search the list and,
     * if applicable, remove the item.
     * Do not assume that the lots are stored in numerical order.
     *
     * Returns true if successful, false otherwise (auction closed,
     * lot does not exist, or lot has a bid).
     *
     * @param number The number of the lot to be removed.
     * @return true if the lot was sucessfully removed
     */
    public boolean removeLot(int number)
    {

        if(auctionOpen == true){
            for(Iterator<Lot> it = lots.iterator(); it.hasNext();){

                Lot lot = it.next();

                if(lot.getNumber() == number){

                    if(lot.getHighestBid() != null){
                        //theres a bid
                        return false;
                    }

                    it.remove();
                    return true;

                } 

            }
        }

        return false;
    }

}