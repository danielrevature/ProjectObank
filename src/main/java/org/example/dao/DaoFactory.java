package org.example.dao;

public class DaoFactory {
    private static IUserDao iuserDao;
    private static ITransactionsDao itransactionsdao;
    private static IMainAccountDao imainaccountdao;

    private DaoFactory() {

    }

    @SuppressWarnings("unused")
    public static IUserDao getUserDao() {
        if (iuserDao == null) {
            iuserDao = new UserController();
        }
        return iuserDao;
    }


    public static ITransactionsDao getTransactionsDao() {
        if (itransactionsdao == null) {
            itransactionsdao = new TransactionsDao();
        }
        return itransactionsdao;
    }

    public static IMainAccountDao getMainAccountDao() {
        if (imainaccountdao == null) {
            imainaccountdao = new MainAccountDao();
        }
        return imainaccountdao;
    }
}
