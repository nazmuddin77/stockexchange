package com.example.data.database.entities;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.JoinProperty;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.ToMany;

import java.util.List;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;

/**
 * Created by nazmuddinmavliwala on 29/10/2017.
 */

@Entity(active = true)
public class StockEntity {

    @Id
    long id;

    @NotNull
    private String name;

    @NotNull
    private String tickrName;

    @ToMany(joinProperties = {
            @JoinProperty(
                    name = "id",
                    referencedName = "stockId"
            )
    })
    private List<StockPriceEntity> stockPrices;

/** Used to resolve relations */
@Generated(hash = 2040040024)
private transient DaoSession daoSession;

/** Used for active entity operations. */
@Generated(hash = 186474315)
private transient StockEntityDao myDao;

@Generated(hash = 162690501)
public StockEntity(long id, @NotNull String name, @NotNull String tickrName) {
    this.id = id;
    this.name = name;
    this.tickrName = tickrName;
}

@Generated(hash = 1239721677)
public StockEntity() {
}

public long getId() {
    return this.id;
}

public void setId(long id) {
    this.id = id;
}

public String getName() {
    return this.name;
}

public void setName(String name) {
    this.name = name;
}

public String getTickrName() {
    return this.tickrName;
}

public void setTickrName(String tickrName) {
    this.tickrName = tickrName;
}

/**
 * To-many relationship, resolved on first access (and after reset).
 * Changes to to-many relations are not persisted, make changes to the target entity.
 */
@Generated(hash = 826911929)
public List<StockPriceEntity> getStockPrices() {
    if (stockPrices == null) {
        final DaoSession daoSession = this.daoSession;
        if (daoSession == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        StockPriceEntityDao targetDao = daoSession.getStockPriceEntityDao();
        List<StockPriceEntity> stockPricesNew = targetDao
                ._queryStockEntity_StockPrices(id);
        synchronized (this) {
            if (stockPrices == null) {
                stockPrices = stockPricesNew;
            }
        }
    }
    return stockPrices;
}

/** Resets a to-many relationship, making the next get call to query for a fresh result. */
@Generated(hash = 555804924)
public synchronized void resetStockPrices() {
    stockPrices = null;
}

/**
 * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
 * Entity must attached to an entity context.
 */
@Generated(hash = 128553479)
public void delete() {
    if (myDao == null) {
        throw new DaoException("Entity is detached from DAO context");
    }
    myDao.delete(this);
}

/**
 * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
 * Entity must attached to an entity context.
 */
@Generated(hash = 1942392019)
public void refresh() {
    if (myDao == null) {
        throw new DaoException("Entity is detached from DAO context");
    }
    myDao.refresh(this);
}

/**
 * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
 * Entity must attached to an entity context.
 */
@Generated(hash = 713229351)
public void update() {
    if (myDao == null) {
        throw new DaoException("Entity is detached from DAO context");
    }
    myDao.update(this);
}

/** called by internal mechanisms, do not call yourself. */
@Generated(hash = 1530664372)
public void __setDaoSession(DaoSession daoSession) {
    this.daoSession = daoSession;
    myDao = daoSession != null ? daoSession.getStockEntityDao() : null;
}
}
