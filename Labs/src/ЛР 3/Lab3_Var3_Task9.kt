package `ЛР 3`

/*
Создать приложение, удовлетворяющее требованиям, приведенным в задании.
Аргументировать принадлежность классу каждого создаваемого метода и корректно переопределить для каждого класса методы equals(), hashCode(), toString().
9. Создать объект класса Фотоальбом, используя класс Фотография.
Методы: задать название фотографии, дополнить фотоальбом фотографией, вывести на консоль количество фотографий.
 */
import java.util.Objects

internal class Photo(private var title: String) {
    fun getTitle(): String {
        return title
    }

    fun setTitle(title: String) {
        this.title = title
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        val photo = other as Photo
        return title == photo.title
    }

    override fun hashCode(): Int {
        return Objects.hash(title)
    }

    override fun toString(): String {
        return "Photo{" +
                "title='" + title + '\'' +
                '}'
    }
}

internal class PhotoAlbum {
    private val photos = ArrayList<Photo>()

    fun addPhoto(photo: Photo) {
        photos.add(photo)
    }

    fun numberOfPhotos(): Int {
        return photos.size
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        val album = other as PhotoAlbum
        return photos == album.photos
    }

    override fun hashCode(): Int {
        return Objects.hash(photos)
    }

    override fun toString(): String {
        return "PhotoAlbum{" +
                "photos=" + photos +
                '}'
    }
}

object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        val photoAlbum = PhotoAlbum()

        val photo1 = Photo("Nature")
        val photo2 = Photo("City")
        val photo3 = Photo("Travel")

        photoAlbum.addPhoto(photo1)
        photoAlbum.addPhoto(photo2)
        photoAlbum.addPhoto(photo3)

        println("Number of photos in the album: " + photoAlbum.numberOfPhotos())
    }
}
