package by.ansgar.android.booknavigationa.database.entity;

import java.util.UUID;

/**
 * Created by kirila on 8.7.16.
 */
public class Book {

    private UUID mId;
    private String mCover;
    private String mTitle;
    private String mPublished;
    private String mSeries;
    private String mSeriesNumb;
    private String mDescription;
    private String mAuthorName;
    private String mRead;
    private String mInList;

    public Book() {

    }

    public Book(UUID uuid) {
        mId = uuid;
    }

    public Book(String title, String published, String series, String seriesNumb,
                String description, String authorName, UUID id, String read, String inList,
            String cover) {
        this.mTitle = title;
        this.mCover = cover;
        this.mPublished = published;
        this.mSeries = series;
        this.mSeriesNumb = seriesNumb;
        this.mDescription = description;
        this.mAuthorName = authorName;
        this.mId = id;
        this.mRead = read;
        this.mInList = inList;
    }

    public UUID getId() {
        return mId;
    }

    public void setId(UUID id) {
        this.mId = id;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        this.mTitle = title;
    }

    public String getPublished() {
        return mPublished;
    }

    public void setPublished(String published) {
        this.mPublished = published;
    }

    public String getSeries() {
        return mSeries;
    }

    public void setSeries(String series) {
        this.mSeries = series;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        this.mDescription = description;
    }

    public String getSeriesNumb() {
        return mSeriesNumb;
    }

    public void setSeriesNumb(String seriesNumb) {
        this.mSeriesNumb = seriesNumb;
    }

    public String getAuthorName() {
        return mAuthorName;
    }

    public void setAuthorName(String authorName) {
        this.mAuthorName = authorName;
    }

    public String getRead() {
        return mRead;
    }

    public void setRead(String read) {
        mRead = read;
    }

    public String getInList() {
        return mInList;
    }

    public void setInList(String inList) {
        mInList = inList;
    }

    public String getCover() {
        return mCover;
    }

    public void setCover(String cover) {
        mCover = cover;
    }
}
