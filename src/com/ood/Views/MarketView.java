package com.ood.Views;

import com.ood.Characters.GeneralHero;
import com.ood.Characters.ICharacter;
import com.ood.Inventory.IInventory;
import com.ood.Item.IItem;
import com.ood.Team.SimpleCollection;
import com.ood.Util.ParseCollection;

import java.util.ArrayList;
import java.util.List;

/**
 * The view component for market
 */
public class MarketView extends AbsGameView{
    public void showMenu(List<List<String>> data){
        int index=0;
        for(List<String > lines:data)
        {
            lines.add(0,"index:"+index++);
        }
        joutAsTableIrregular(data);
    }

    @Override
    public void displayGameTitle() {

    }

    @Override
    public void displayPlayerScoreTable() {

    }

    private List<String> combineDataAndTitle(List<String> data, List<String> title)
    {
        List<String > ans=new ArrayList<>();
        for(int i=0;i<data.size();i++)
        {
            ans.add(title.get(i)+":"+data.get(i));
        }
        return ans;
    }

    @Override
    public void joutHelp() {

    }

    public void disPlayCheckoutInfo(GeneralHero customer, IItem checkoutItem){
        String name=customer.getName();
        float price=checkoutItem.getOriginalPrice();
        jout(name+" spend "+price+", and got "+checkoutItem.getName());
    }
    @Override
    public void displayCharacterInventory(ICharacter customer){
        IInventory<IItem> inv=customer.getInventory();
        for(int i=0;i<inv.getSize();i++)
        {
            jout("["+i+"]"+inv.get(i).getName()+" sell price: "+inv.get(i).getSellPrice());
        }
    }

    /**
     * do nothing
     * @return
     */
    @Override
    public int collectCharactersCount() {
        return 0;
    }

    @Override
    public void reportCharacterInfo(ICharacter character) {

    }

    @Override
    public List<String> collectPlayersName(int size) {
        return null;
    }

    @Override
    public int collectPlayersCount() {
        return 0;
    }

    @Override
    public int collectPlayersCount(int lowerBound, int upperBound) {
        return 0;
    }

    @Override
    public void displayParserInfo(ParseCollection parseCollection, boolean showIndex) {

    }

    @Override
    public int displayPlayerChooseCharacter(int bound, String name, int lane) {
        return 0;
    }


    @Override
    public void displayCharactersInfo(SimpleCollection<ICharacter> characterCollection) {

    }

    public int collectCustomersChoice(int upperBound){
        jout("Please choose one item");
        int choice = jin_BorderedInt(0,upperBound);
        return choice;
    }

    @Override
    public void showMarketView() {

    }


    public void disPlayCannotSellInfo() {
        joutDivider();
        jout("You got nothing to sell!");
        joutDivider();
    }

    public void disPlayCannotBuyInfo() {
        joutDivider();
        jout("You cannot buy this item!");
        joutDivider();
    }


    public void displayMarketWelcomeMessage(String name) {
        jout(name+", Welcome!");
    }

    public void disPlayCheckInInfo(GeneralHero customer, IItem tobeSoldItem) {
        String name=customer.getName();
        float price=tobeSoldItem.getSellPrice();
        jout(name+" got "+price+" from selling "+tobeSoldItem.getName());
    }
}
