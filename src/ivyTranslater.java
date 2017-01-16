import fr.dgac.ivy.* ;

class ivyTranslater implements IvyMessageListener {

    private Ivy bus;

    public ivyTranslater() throws IvyException {
        // initialization, name and ready message
        bus = new Ivy("IvyTranslater","IvyTranslater Ready", null);
        // classical subscription
        bus.bindMsg("sra5 Parsed=(.*) Confidence",this);
        // inner class subscription ( think awt )
        bus.bindMsg("^Bye$", (client, args) -> {
            // leaves the bus, and as it is the only thread, quits
            bus.stop();
        });
        bus.start("127.255.255.255:2010"); // starts the bus on the default domain
    }

    // callback associated to the "Hello" messages"
    public void receive(IvyClient client, String[] args) {

            System.out.println(args[0]);
    }

    public void sendMsg(String msg){
        try {
            bus.sendMsg(msg);
            System.out.println(msg);
        } catch (IvyException e) {
            e.printStackTrace();
        }
    }

}