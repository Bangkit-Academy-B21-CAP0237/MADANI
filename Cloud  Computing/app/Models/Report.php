<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Model;
use Illuminate\Database\Eloquent\Factories\HasFactory;
use Jedrzej\Pimpable\PimpableTrait;

class Report extends Model 
{
    use HasFactory, PimpableTrait;

    public $searchable = ['*'];
    public $sortable = ['*'];
    protected $withable = ['*'];

    /**
     * The attributes that are mass assignable.
     *
     * @var array
     */
    protected $fillable = [
        'user_id',
        'map_id',
        'title',
        'description',
        'address',
        'category',
        'photo',
        'status',
    ];
}
