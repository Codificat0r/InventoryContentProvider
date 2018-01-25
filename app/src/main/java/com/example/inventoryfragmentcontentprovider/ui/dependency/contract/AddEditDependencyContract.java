package com.example.inventoryfragmentcontentprovider.ui.dependency.contract;

import com.example.inventoryfragmentcontentprovider.data.db.model.Dependency;
import com.example.inventoryfragmentcontentprovider.ui.base.BasePresenter;
import com.example.inventoryfragmentcontentprovider.ui.base.BaseView;

/**
 * Created by usuario on 23/11/17.
 */

public interface AddEditDependencyContract {
    interface View extends BaseView{
        void setNameError();
        void setShortnameError();
        void setDescriptionError();
        void setShortnameLenghtError();
        void showDependencyList();
        void showNameEmptyError();
        void showShortnameEmptyError();
        void showShortnameLenghtError();
        void showDescriptionEmptyError();

        void showOnDatabaseError(Error error);

        void showOnDatabaseError(Exception exception);
    }

    interface Presenter extends BasePresenter{
        void validateDependency(Dependency dependency);
        void edit(Dependency dependency);
    }
}
